package com.ZuuleGateway.Config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import com.ZuuleGateway.configRepository.DataSourceConfigRepository;

@Component
public class TenantDataSource implements Serializable {

	private HashMap<String, DataSource> datasource = new HashMap<>();
	@Autowired
	private DataSourceConfigRepository configRepository;

	public DataSource getDataSource(String name) {
		if (datasource.get(name) != null) {
			return datasource.get(name);
		}
		DataSource dataSource = createDataSource(name);
		if (datasource != null) {
			datasource.put(name, dataSource);
		}
		return dataSource;
	}

	@PostConstruct
	public Map<String, DataSource> getAll() {
		List<DatasourceConfig> configList = configRepository.findAll();
		Map<String, DataSource> result = new HashMap<>();
		for (DatasourceConfig config : configList) {
			DataSource dataSource = getDataSource(config.getName());
			result.put(config.getName(), dataSource);
		}
		return result;
	}

	private DataSource createDataSource(String name) {
		DatasourceConfig config = configRepository.findByName(name);
		if (config != null) {
			DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(config.getDriverClassname())
					.username(config.getUsername()).password(config.getPassword()).url(config.getUrl());
			DataSource ds = factory.build();
			return ds;
		}
		return null;
	}

}

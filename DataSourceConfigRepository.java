package com.ZuuleGateway.configRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ZuuleGateway.Config.DatasourceConfig;

@Component
@Repository
public interface DataSourceConfigRepository extends JpaRepository<DatasourceConfig, Long> {

DatasourceConfig findByName(String name);

}
package com.ZuuleGateway.Config;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "Datasource")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class DatasourceConfig implements Serializable {
	private static final long serilialversionUID = 663537623778l;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String url;
	private String username;
	private String password;
	private String driverClassname;
	private boolean Initialize;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriverClassname() {
		return driverClassname;
	}
	public void setDriverClassname(String driverClassname) {
		this.driverClassname = driverClassname;
	}
	public boolean isInitialize() {
		return Initialize;
	}
	public void setInitialize(boolean initialize) {
		Initialize = initialize;
	}
	public static long getSerilialversionuid() {
		return serilialversionUID;
	}

}
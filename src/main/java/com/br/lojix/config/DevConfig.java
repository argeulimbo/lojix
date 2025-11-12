package com.br.lojix.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.br.lojix.service.DbService;

public class DevConfig {
	
	@Autowired
	private DbService dbService;
	
	@Value("$(spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	public boolean instanciaDB() {
		if (value.equals("create")) {
			this.dbService.instanciaDB();
		}
		return false;
	}

}

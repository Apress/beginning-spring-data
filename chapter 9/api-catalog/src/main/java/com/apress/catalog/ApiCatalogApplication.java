package com.apress.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("com.apress.catalog.repository")
public class ApiCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCatalogApplication.class, args);
	}
}

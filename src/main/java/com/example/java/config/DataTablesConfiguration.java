package com.example.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesConfiguration.class, basePackages = "com.example.java.datatables")
public class DataTablesConfiguration {

}

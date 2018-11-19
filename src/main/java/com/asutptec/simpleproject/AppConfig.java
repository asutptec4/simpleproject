package com.asutptec.simpleproject;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan("com.asutptec.simpleproject")
public class AppConfig {

    private static final String dbconfig = "src/main/resources/dbconfig.properties";

    @Bean
    public DataSource dataSource() {
	HikariConfig config = new HikariConfig(dbconfig);
	return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	return new JdbcTemplate(dataSource);
    }
}

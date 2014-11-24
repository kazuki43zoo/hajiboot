package com.example;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    DataSource realDataSource(DataSourceProperties dataSourceProperties) {
        return DataSourceBuilder.create(dataSourceProperties.getClassLoader())
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUsername())
                .password(dataSourceProperties.getPassword())
                .build();
    }

    @Bean
    DataSource dataSource(DataSource dataSource) {
        return new Log4jdbcProxyDataSource(dataSource);
    }

}

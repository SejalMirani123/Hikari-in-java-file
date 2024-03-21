package com.example.demo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;



@Configuration
public class CustomDataSourceConfig {


    @Bean
    public DataSource getMySQLDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/database");
        config.setUsername("root");
        config.setPassword("root");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setAutoCommit(true);
        config.setConnectionTimeout(250);
        config.setIdleTimeout(600000);
        config.setMaxLifetime(1800000);
        config.setValidationTimeout(5000);
        config.setMaximumPoolSize(10);
        config.setPoolName("MyHikariCP");
        config.setAllowPoolSuspension(false);
        config.setReadOnly(false);
        config.setLeakDetectionThreshold(0);
        config.setMinimumIdle(10);
        config.setInitializationFailTimeout(1);
        config.setConnectionTestQuery("SELECT 1");

        try {
            return new HikariDataSource(config);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

//    @Bean
//    public DataSource getMySQLDataSource() {
//        Map<String, String> map = new HashMap<>();
//        map.put("jdbcUrl", "jdbc:mysql://localhost:3306/database");
//        map.put("username", "root");
//        map.put("password", "root");
//        map.put("driverClassName", "com.mysql.cj.jdbc.Driver");
//
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl(map.get("jdbcUrl"));
//        hikariConfig.setUsername(map.get("username"));
//        hikariConfig.setPassword(map.get("password"));
//        hikariConfig.setDriverClassName(map.get("driverClassName"));
//
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            String Name = entry.getKey();
//            String Value = entry.getValue();
//            System.out.println("Key: " + Name + ", Value: " + Value);
//            hikariConfig.addDataSourceProperty(Name, Value);
//        }
//
//        try {
//            HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
//            return hikariDataSource;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        }
//    }







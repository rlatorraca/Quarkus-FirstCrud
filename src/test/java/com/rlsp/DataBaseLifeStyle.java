package com.rlsp;

import com.mysql.cj.jdbc.integration.c3p0.MysqlConnectionTester;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.MySQLContainer;

import java.util.HashMap;
import java.util.Map;

public class DataBaseLifeStyle implements QuarkusTestResourceLifecycleManager {

    private static MySQLContainer<?> MYSQL = new MySQLContainer<>("mysq/mysql-server:8.0.21");

    @Override
    public Map<String, String> start() {
        MYSQL.start();
        Map<String , String> properties = new HashMap<>();
        properties.put("quarkus.datasource.jdbc.url", MYSQL.getJdbcUrl());
        properties.put("quarkus.datasource.username", MYSQL.getUsername());
        properties.put("quarkus.datasource.password", MYSQL.getPassword());
        return properties;
    }

    @Override
    public void stop() {
        if(MYSQL != null) {
            MYSQL.stop();
        }
    }
}

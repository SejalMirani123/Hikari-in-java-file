package com.example.demo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Repository
public class YourDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private DataSource dataSource;

//    public void insertData(String columnName, String anotherColumn, int numericColumn, boolean booleanColumn) {
//        String sql = "INSERT INTO your_table (column_name, another_column, " +
//                "numeric_column, boolean_column) " +
//                "VALUES (:columnName, :anotherColumn, :numericColumn, :booleanColumn)";
//
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("columnName", columnName);
//        parameters.put("anotherColumn", anotherColumn);
//        parameters.put("numericColumn", numericColumn);
//        parameters.put("booleanColumn", booleanColumn);
//
//
//        namedParameterJdbcTemplate.update(sql, parameters);
//    }

    public void insertData(String columnName, String anotherColumn, int numericColumn, boolean booleanColumn) {
        String sql = "INSERT INTO your_table (column_name, another_column, numeric_column, boolean_column) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, columnName);
            statement.setString(2, anotherColumn);
            statement.setInt(3, numericColumn);
            statement.setBoolean(4, booleanColumn);
            statement.setQueryTimeout(1); // Set query timeout as desired (in seconds)
            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(YourDataDTO yourData) {
        insertData(
                yourData.getColumnName(),
                yourData.getAnotherColumn(),
                yourData.getNumericColumn(),
                yourData.isBooleanColumn()
        );
    }

//    public void insertData(String columnName, String anotherColumn, int numericColumn, boolean booleanColumn) {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
//        config.setUsername("root");
//        config.setPassword("root");
//        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        config.setAutoCommit(true);
//        config.setConnectionTimeout(1000);
//        config.setIdleTimeout(600000);
//        config.setMaxLifetime(1800000);
//        config.setValidationTimeout(5000);
//        config.setMaximumPoolSize(10);
//        config.setPoolName("MyHikariCP");
//        config.setAllowPoolSuspension(false);
//        config.setReadOnly(false);
//        config.setLeakDetectionThreshold(0);
//        config.setMinimumIdle(10);
//        config.setInitializationFailTimeout(1);
//        config.setConnectionTestQuery("SELECT 1");
//
//        try (HikariDataSource dataSource = new HikariDataSource(config);
//             Connection connection = dataSource.getConnection();
//             Statement statement = connection.createStatement()) {
//             statement.setQueryTimeout(1);
//            int rowsAffected = statement.executeUpdate("INSERT INTO your_table (column_name, another_column, numeric_column, boolean_column) " +
//                    "VALUES ('value1', 'value2', 123, true)");
//
//            System.out.println("Rows affected: " + rowsAffected);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
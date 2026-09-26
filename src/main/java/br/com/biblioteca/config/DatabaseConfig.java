package br.com.biblioteca.config;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseConfig {
    private final HikariDataSource dataSource; 

    public DatabaseConfig() {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        config.setJdbcUrl("jdbc:mysql://localhost:3306/biblioteca");

        config.setUsername("root");
        config.setPassword("");
        
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);

        this.dataSource = new HikariDataSource(config);

    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }

}

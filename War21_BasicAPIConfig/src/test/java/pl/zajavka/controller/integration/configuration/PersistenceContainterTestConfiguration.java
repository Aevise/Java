package pl.zajavka.controller.integration.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

@TestConfiguration
public class PersistenceContainterTestConfiguration {
    public static final String USERNAME = "test";
    public static final String PASSWORD = "test";
    public static final String POSTGRESQL = "postgresql";
    public static final String POSTGRESQL_CONTAINER = "postgres:15.0";

    @Bean
    @Qualifier(POSTGRESQL)
    PostgreSQLContainer<?> postgreSQLContainer() {
        PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(POSTGRESQL_CONTAINER)
                .withUsername(USERNAME)
                .withPassword(PASSWORD);
        postgreSQLContainer.start();
        return postgreSQLContainer;
    }

    @Bean
    DataSource dataSource(final PostgreSQLContainer<?> postgreSQLContainer){
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .driverClassName(postgreSQLContainer.getDriverClassName())
                .url(postgreSQLContainer.getJdbcUrl())
                .username(postgreSQLContainer.getUsername())
                .password(postgreSQLContainer.getPassword())
                .build();
    }

}

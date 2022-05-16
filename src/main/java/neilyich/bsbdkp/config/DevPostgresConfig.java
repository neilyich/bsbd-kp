package neilyich.bsbdkp.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

@Slf4j
@Configuration
@Profile("dev")
public class DevPostgresConfig {

    @Value("${postgresql.docker.image.name:postgres:14}")
    private String postgresqlImageName;

    @Bean
    public PostgreSQLContainer postgreSQLContainer() {
        final PostgreSQLContainer container = new PostgreSQLContainer<>(postgresqlImageName);
        container.start();
        log.info("DB Url: {}", container.getJdbcUrl());
        log.info("DB User: {}", container.getUsername());
        log.info("DB Pass: {}", container.getPassword());
        return container;
    }

    @Bean
    @Primary
    public DataSource dataSource(PostgreSQLContainer postgresContainer) {
        final HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setPassword(postgresContainer.getPassword());
        hikariConfig.setUsername(postgresContainer.getUsername());
        hikariConfig.setJdbcUrl(postgresContainer.getJdbcUrl());
        return new HikariDataSource(hikariConfig);
    }

}
package fr.blacroix.poc.multifront.backend.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfiguration {

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setDatabaseChangeLogLockTable("liquibase_change_log_lock");
        liquibase.setDatabaseChangeLogTable("liquibase_change_log");
        liquibase.setChangeLog("classpath:db/liquibase-master.xml");
        return liquibase;
    }
}

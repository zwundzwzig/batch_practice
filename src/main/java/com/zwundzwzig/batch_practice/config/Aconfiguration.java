package com.zwundzwzig.batch_practice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "AEntityManagerFactory",
        transactionManagerRef = "ATransactionManager",
        basePackages = { "com.zwundzwzig.batch_practice.a.repository" }
)
class Aconfiguration {

    @Autowired
    @Qualifier("ADataSource")
    private DataSource ADataSource;

    @Primary
    @Bean(name = "AEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean AEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(ADataSource)
                .packages("com.zwundzwzig.batch_practice.a.entity")
                .persistenceUnit("A")
                .build();
    }

}
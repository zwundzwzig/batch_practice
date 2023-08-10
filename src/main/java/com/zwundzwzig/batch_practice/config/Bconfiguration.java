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
        entityManagerFactoryRef = "BEntityManagerFactory",
        transactionManagerRef = "BTransactionManager",
        basePackages = { "com.zwundzwzig.batch_practice.b.repository" }
)
class Bconfiguration {

    @Autowired
    @Qualifier("BDataSource")
    private DataSource BDataSource;

    @Bean(name = "BEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean BEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(BDataSource)
                .packages("com.zwundzwzig.batch_practice.b.entity")
                .persistenceUnit("A")
                .build();
    }

}
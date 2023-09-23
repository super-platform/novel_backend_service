package com.platform.configs;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = {
        "com.platform.repositories.postgres"
})
@EntityScan(basePackages = {"com.platform.entities.postgres"}, basePackageClasses = {
        Jsr310JpaConverters.class
})
public class PostgresDBConfig {
    @Autowired
    private Environment env;

    @Bean(name = "dataSource")
    public DataSource customerDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        dataSource.setConnectionTestQuery(env.getProperty("spring.datasource.hikari.connection-test-query"));
        dataSource.setMinimumIdle(env.getProperty("spring.datasource.hikari.minimum-idle", Integer.class));
        dataSource.setMaximumPoolSize(env.getProperty("spring.datasource.hikari.maximum-pool-size", Integer.class));
        dataSource.setPoolName(env.getProperty("spring.datasource.hikari.pool-name"));
        dataSource.setAutoCommit(env.getProperty("spring.datasource.hikari.auto-commit", Boolean.class));
        dataSource.setConnectionTimeout(env.getProperty("spring.datasource.hikari.connection-timeout", Integer.class));
        dataSource.setIdleTimeout(env.getProperty("spring.datasource.hikari.idle-timeout", Integer.class));
        dataSource.setMaxLifetime(env.getProperty("spring.datasource.hikari.max-lifetime", Integer.class));


        return dataSource;
    }

    private JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL9Dialect");
        return hibernateJpaVendorAdapter;
    }

    @PersistenceContext(unitName = "customerUnit")
    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                     @Qualifier("dataSource") DataSource dataSource){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = builder.dataSource(dataSource)
                .persistenceUnit("customerUnit").build();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.kazenokumo.reportdataservice.entities.postgres");
        localContainerEntityManagerFactoryBean.afterPropertiesSet();
        return localContainerEntityManagerFactoryBean.getObject();
    }

    @Bean(name = "transactionManager")
    @Qualifier(value = "entityManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory")EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
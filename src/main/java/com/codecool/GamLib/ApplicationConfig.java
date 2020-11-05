package com.codecool.GamLib;

import com.codecool.GamLib.model.Game;
import com.codecool.GamLib.model.Platform;
import com.codecool.GamLib.repositories.GameRepository;
import com.codecool.GamLib.repositories.PlatformRepository;
import com.codecool.GamLib.services.GamLibService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
class ApplicationConfig {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.codecool.GamLib.model");
        factory.setDataSource(dataSource());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

    @Bean
    public GamLibService<Platform, PlatformRepository> platformService(BeanFactory beanFactory) {
        ObjectProvider<PlatformRepository> beanProvider = beanFactory.getBeanProvider(PlatformRepository.class);
        return new GamLibService<Platform, PlatformRepository>(beanProvider.getIfAvailable());
    }

    @Bean
    public GamLibService<Game, GameRepository> gameService(BeanFactory beanFactory) {
        ObjectProvider<GameRepository> beanProvider = beanFactory.getBeanProvider(GameRepository.class);
        return new GamLibService<Game, GameRepository>(beanProvider.getIfAvailable());
    }


}

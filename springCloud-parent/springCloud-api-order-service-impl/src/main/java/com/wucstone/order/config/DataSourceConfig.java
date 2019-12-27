package com.wucstone.order.config;

import io.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Component
public class DataSourceConfig {


    @Bean(name = "demoDataSource")
    @ConfigurationProperties(prefix = "sharding.jdbc.datasource.ds_0")
    @Primary
    public DataSource demoDataSource() throws Exception{
        return DataSourceBuilder.create().build();

    }


    @Bean(name = "demoTransactionTemplate")
    @Primary
    public TransactionTemplate demoTransactionTemplate(@Qualifier("demoTransactionManager") PlatformTransactionManager platformTransactionManager){
        return new TransactionTemplate(platformTransactionManager);
    }

    @Bean(name = "demoTransactionManager")
    @Primary
    public PlatformTransactionManager demoTransactionManager(@Qualifier("demoDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}

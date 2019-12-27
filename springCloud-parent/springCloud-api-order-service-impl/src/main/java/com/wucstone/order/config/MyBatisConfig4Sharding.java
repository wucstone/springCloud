package com.wucstone.order.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import io.shardingsphere.api.config.ShardingRuleConfiguration;
import io.shardingsphere.core.yaml.sharding.YamlShardingRuleConfiguration;
import io.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.wucstone.order.mapper.sharding"},sqlSessionFactoryRef = "sqlSessionFactory4Sharding", sqlSessionTemplateRef = "sqlSessionTemplate4Sharding")
public class MyBatisConfig4Sharding {

    @Autowired
    @Qualifier("shardingDataSource")
    private DataSource dataSource;


    @Bean(name = "shardingDataSource")
    public DataSource shardingDataSource() throws Exception{
        Resource resource = new ClassPathResource("sharding-jdbc.yml");
        return YamlShardingDataSourceFactory.createDataSource(resource.getFile());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory4Sharding() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        MybatisConfiguration mybatisConfiguration=  new MybatisConfiguration();
        mybatisConfiguration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(mybatisConfiguration);
        //手动设置session工厂时，需要手动添加分页插件
        Interceptor[] plugins = new Interceptor[1];
        plugins[0] = paginationInterceptor();
        sqlSessionFactoryBean.setPlugins(plugins);
        return sqlSessionFactoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate4Sharding() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory4Sharding()); // 使用上面配置的Factory
        return template;
    }
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}

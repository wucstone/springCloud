package com.wucstone.order.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
//@MapperScan(basePackages = {"com.wucstone.order.mapper.data"},sqlSessionFactoryRef = "sqlSessionFactory4Demo", sqlSessionTemplateRef = "sqlSessionTemplate4Demo")
public class MyBatisConfig4Demo {

//    @Autowired
//    @Qualifier("demoDataSource")
//    private DataSource demoDataSource;
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory4Demo() throws Exception {
//
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(demoDataSource);
//        MybatisConfiguration mybatisConfiguration=  new MybatisConfiguration();
//        mybatisConfiguration.setMapUnderscoreToCamelCase(true);
//        sqlSessionFactoryBean.setConfiguration(mybatisConfiguration);
//        //手动设置session工厂时，需要手动添加分页插件
//        Interceptor[] plugins = new Interceptor[1];
//        plugins[0] = paginationInterceptor();
//        sqlSessionFactoryBean.setPlugins(plugins);
//        return sqlSessionFactoryBean.getObject();
//
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate4Demo() throws Exception {
//        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory4Demo()); // 使用上面配置的Factory
//        return template;
//    }
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        return new PaginationInterceptor();
//    }

}

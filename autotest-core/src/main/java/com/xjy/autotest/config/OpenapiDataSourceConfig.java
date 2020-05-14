package com.xjy.autotest.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.xjy.autotest.mybatis.MultiBeanNameGenerator;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "dal.dao.openapi", sqlSessionFactoryRef = "openapiSqlSessionFactory", nameGenerator =
		MultiBeanNameGenerator.class)
public class OpenapiDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.openapi.url}")
    private String url;

    @Value("${ds.openapi.username}")
    private String username;

    @Value("${ds.openapi.password}")
    private String password;

    @Value("${ds.openapi.driverClassName}")
    private String driverClassName;

    @Bean(name = "openapiDataSource")
    public DataSource openapiDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "openapiTransactionManager")
    public DataSourceTransactionManager openapiTransactionManager() {
        return new DataSourceTransactionManager(openapiDataSource());
    }

    @Bean(name = "openapiSqlSessionFactory")
    public SqlSessionFactory openapiSqlSessionFactory(@Qualifier("openapiDataSource") DataSource openapiDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(openapiDataSource);
        return sessionFactory.getObject();
    }
}
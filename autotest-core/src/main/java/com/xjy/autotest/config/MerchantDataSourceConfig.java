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
@MapperScan(basePackages = "dal.dao.merchant", sqlSessionFactoryRef = "merchantSqlSessionFactory", nameGenerator =
		MultiBeanNameGenerator.class)
public class MerchantDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.merchant.url}")
    private String url;

    @Value("${ds.merchant.username}")
    private String username;

    @Value("${ds.merchant.password}")
    private String password;

    @Value("${ds.merchant.driverClassName}")
    private String driverClassName;

    @Bean(name = "merchantDataSource")
    public DataSource merchantDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "merchantTransactionManager")
    public DataSourceTransactionManager merchantTransactionManager() {
        return new DataSourceTransactionManager(merchantDataSource());
    }

    @Bean(name = "merchantSqlSessionFactory")
    public SqlSessionFactory merchantSqlSessionFactory(@Qualifier("merchantDataSource") DataSource merchantDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(merchantDataSource);
        return sessionFactory.getObject();
    }
}
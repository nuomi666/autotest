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
@MapperScan(basePackages = "dal.dao.shelluser", sqlSessionFactoryRef = "shelluserSqlSessionFactory", nameGenerator =
		MultiBeanNameGenerator.class)
public class ShelluserDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.shelluser.url}")
    private String url;

    @Value("${ds.shelluser.username}")
    private String username;

    @Value("${ds.shelluser.password}")
    private String password;

    @Value("${ds.shelluser.driverClassName}")
    private String driverClassName;

    @Bean(name = "shelluserDataSource")
    public DataSource shelluserDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "shelluserTransactionManager")
    public DataSourceTransactionManager shelluserTransactionManager() {
        return new DataSourceTransactionManager(shelluserDataSource());
    }

    @Bean(name = "shelluserSqlSessionFactory")
    public SqlSessionFactory shelluserSqlSessionFactory(@Qualifier("shelluserDataSource") DataSource shelluserDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(shelluserDataSource);
        return sessionFactory.getObject();
    }
}
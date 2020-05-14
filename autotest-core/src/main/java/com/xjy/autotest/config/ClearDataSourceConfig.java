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
@MapperScan(basePackages = "dal.dao.clear", sqlSessionFactoryRef = "clearSqlSessionFactory", nameGenerator =
		MultiBeanNameGenerator.class)
public class ClearDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.clear.url}")
    private String url;

    @Value("${ds.clear.username}")
    private String username;

    @Value("${ds.clear.password}")
    private String password;

    @Value("${ds.clear.driverClassName}")
    private String driverClassName;

    @Bean(name = "clearDataSource")
    public DataSource clearDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "clearTransactionManager")
    public DataSourceTransactionManager clearTransactionManager() {
        return new DataSourceTransactionManager(clearDataSource());
    }

    @Bean(name = "clearSqlSessionFactory")
    public SqlSessionFactory clearSqlSessionFactory(@Qualifier("clearDataSource") DataSource clearDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clearDataSource);
        return sessionFactory.getObject();
    }
}
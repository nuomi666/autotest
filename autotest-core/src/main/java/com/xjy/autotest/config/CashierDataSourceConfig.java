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
@MapperScan(basePackages = "dal.dao.cashier", sqlSessionFactoryRef = "cashierSqlSessionFactory", nameGenerator =
		MultiBeanNameGenerator.class)
public class CashierDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.cashier.url}")
    private String url;

    @Value("${ds.cashier.username}")
    private String username;

    @Value("${ds.cashier.password}")
    private String password;

    @Value("${ds.cashier.driverClassName}")
    private String driverClassName;

    @Bean(name = "cashierDataSource")
    public DataSource cashierDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "cashierTransactionManager")
    public DataSourceTransactionManager cashierTransactionManager() {
        return new DataSourceTransactionManager(cashierDataSource());
    }

    @Bean(name = "cashierSqlSessionFactory")
    public SqlSessionFactory cashierSqlSessionFactory(@Qualifier("cashierDataSource") DataSource cashierDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(cashierDataSource);
        return sessionFactory.getObject();
    }
}
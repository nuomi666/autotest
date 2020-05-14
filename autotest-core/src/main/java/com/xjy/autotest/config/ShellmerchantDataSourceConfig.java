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
@MapperScan(basePackages = "dal.dao.shellmerchant", sqlSessionFactoryRef = "shellmerchantSqlSessionFactory", nameGenerator =
		MultiBeanNameGenerator.class)
public class ShellmerchantDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.shellmerchant.url}")
    private String url;

    @Value("${ds.shellmerchant.username}")
    private String username;

    @Value("${ds.shellmerchant.password}")
    private String password;

    @Value("${ds.shellmerchant.driverClassName}")
    private String driverClassName;

    @Bean(name = "shellmerchantDataSource")
    public DataSource shellmerchantDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "shellmerchantTransactionManager")
    public DataSourceTransactionManager shellmerchantTransactionManager() {
        return new DataSourceTransactionManager(shellmerchantDataSource());
    }

    @Bean(name = "shellmerchantSqlSessionFactory")
    public SqlSessionFactory shellmerchantSqlSessionFactory(@Qualifier("shellmerchantDataSource") DataSource shellmerchantDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(shellmerchantDataSource);
        return sessionFactory.getObject();
    }
}
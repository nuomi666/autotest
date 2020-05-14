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
@MapperScan(basePackages = "dal.dao.pay", sqlSessionFactoryRef = "paySqlSessionFactory", nameGenerator =
		MultiBeanNameGenerator.class)
public class PayDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.pay.url}")
    private String url;

    @Value("${ds.pay.username}")
    private String username;

    @Value("${ds.pay.password}")
    private String password;

    @Value("${ds.pay.driverClassName}")
    private String driverClassName;

    @Bean(name = "payDataSource")
    public DataSource payDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "payTransactionManager")
    public DataSourceTransactionManager payTransactionManager() {
        return new DataSourceTransactionManager(payDataSource());
    }

    @Bean(name = "paySqlSessionFactory")
    public SqlSessionFactory paySqlSessionFactory(@Qualifier("payDataSource") DataSource payDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(payDataSource);
        return sessionFactory.getObject();
    }
}
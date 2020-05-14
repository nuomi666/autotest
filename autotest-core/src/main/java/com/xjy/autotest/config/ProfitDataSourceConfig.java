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
@MapperScan(basePackages = "dal.dao.profit", sqlSessionFactoryRef = "profitSqlSessionFactory", nameGenerator =
		MultiBeanNameGenerator.class)
public class ProfitDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.profit.url}")
    private String url;

    @Value("${ds.profit.username}")
    private String username;

    @Value("${ds.profit.password}")
    private String password;

    @Value("${ds.profit.driverClassName}")
    private String driverClassName;

    @Bean(name = "profitDataSource")
    public DataSource profitDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "profitTransactionManager")
    public DataSourceTransactionManager profitTransactionManager() {
        return new DataSourceTransactionManager(profitDataSource());
    }

    @Bean(name = "profitSqlSessionFactory")
    public SqlSessionFactory profitSqlSessionFactory(@Qualifier("profitDataSource") DataSource profitDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(profitDataSource);
        return sessionFactory.getObject();
    }
}
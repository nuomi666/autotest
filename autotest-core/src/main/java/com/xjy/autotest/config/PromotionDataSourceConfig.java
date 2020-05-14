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
@MapperScan(basePackages = "dal.dao.promotion", sqlSessionFactoryRef = "promotionSqlSessionFactory", nameGenerator =
		MultiBeanNameGenerator.class)
public class PromotionDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.promotion.url}")
    private String url;

    @Value("${ds.promotion.username}")
    private String username;

    @Value("${ds.promotion.password}")
    private String password;

    @Value("${ds.promotion.driverClassName}")
    private String driverClassName;

    @Bean(name = "promotionDataSource")
    public DataSource promotionDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "promotionTransactionManager")
    public DataSourceTransactionManager promotionTransactionManager() {
        return new DataSourceTransactionManager(promotionDataSource());
    }

    @Bean(name = "promotionSqlSessionFactory")
    public SqlSessionFactory promotionSqlSessionFactory(@Qualifier("promotionDataSource") DataSource promotionDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(promotionDataSource);
        return sessionFactory.getObject();
    }
}
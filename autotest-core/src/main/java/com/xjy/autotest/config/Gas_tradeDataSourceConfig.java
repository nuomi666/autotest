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
@MapperScan(basePackages = "dal.dao.gas_trade", sqlSessionFactoryRef = "gas_tradeSqlSessionFactory", nameGenerator =
		MultiBeanNameGenerator.class)
public class Gas_tradeDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.gas_trade.url}")
    private String url;

    @Value("${ds.gas_trade.username}")
    private String username;

    @Value("${ds.gas_trade.password}")
    private String password;

    @Value("${ds.gas_trade.driverClassName}")
    private String driverClassName;

    @Bean(name = "gas_tradeDataSource")
    public DataSource gas_tradeDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "gas_tradeTransactionManager")
    public DataSourceTransactionManager gas_tradeTransactionManager() {
        return new DataSourceTransactionManager(gas_tradeDataSource());
    }

    @Bean(name = "gas_tradeSqlSessionFactory")
    public SqlSessionFactory gas_tradeSqlSessionFactory(@Qualifier("gas_tradeDataSource") DataSource gas_tradeDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(gas_tradeDataSource);
        return sessionFactory.getObject();
    }
}
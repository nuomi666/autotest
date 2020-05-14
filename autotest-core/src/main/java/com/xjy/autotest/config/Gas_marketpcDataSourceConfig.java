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
@MapperScan(basePackages = "dal.dao.gas_marketpc", sqlSessionFactoryRef = "gas_marketpcSqlSessionFactory", nameGenerator =
		MultiBeanNameGenerator.class)
public class Gas_marketpcDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.gas_marketpc.url}")
    private String url;

    @Value("${ds.gas_marketpc.username}")
    private String username;

    @Value("${ds.gas_marketpc.password}")
    private String password;

    @Value("${ds.gas_marketpc.driverClassName}")
    private String driverClassName;

    @Bean(name = "gas_marketpcDataSource")
    public DataSource gas_marketpcDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "gas_marketpcTransactionManager")
    public DataSourceTransactionManager gas_marketpcTransactionManager() {
        return new DataSourceTransactionManager(gas_marketpcDataSource());
    }

    @Bean(name = "gas_marketpcSqlSessionFactory")
    public SqlSessionFactory gas_marketpcSqlSessionFactory(@Qualifier("gas_marketpcDataSource") DataSource gas_marketpcDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(gas_marketpcDataSource);
        return sessionFactory.getObject();
    }
}
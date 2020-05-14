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
@MapperScan(basePackages = "dal.dao.gas_merchant", sqlSessionFactoryRef = "gas_merchantSqlSessionFactory", nameGenerator =
		MultiBeanNameGenerator.class)
public class Gas_merchantDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.gas_merchant.url}")
    private String url;

    @Value("${ds.gas_merchant.username}")
    private String username;

    @Value("${ds.gas_merchant.password}")
    private String password;

    @Value("${ds.gas_merchant.driverClassName}")
    private String driverClassName;

    @Bean(name = "gas_merchantDataSource")
    public DataSource gas_merchantDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "gas_merchantTransactionManager")
    public DataSourceTransactionManager gas_merchantTransactionManager() {
        return new DataSourceTransactionManager(gas_merchantDataSource());
    }

    @Bean(name = "gas_merchantSqlSessionFactory")
    public SqlSessionFactory gas_merchantSqlSessionFactory(@Qualifier("gas_merchantDataSource") DataSource gas_merchantDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(gas_merchantDataSource);
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }
}
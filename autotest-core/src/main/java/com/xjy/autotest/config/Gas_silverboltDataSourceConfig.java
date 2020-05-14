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
@MapperScan(basePackages = "dal.dao.gas_silverbolt", sqlSessionFactoryRef = "gas_silverboltSqlSessionFactory", nameGenerator =
		MultiBeanNameGenerator.class)
public class Gas_silverboltDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.gas_silverbolt.url}")
    private String url;

    @Value("${ds.gas_silverbolt.username}")
    private String username;

    @Value("${ds.gas_silverbolt.password}")
    private String password;

    @Value("${ds.gas_silverbolt.driverClassName}")
    private String driverClassName;

    @Bean(name = "gas_silverboltDataSource")
    public DataSource gas_silverboltDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "gas_silverboltTransactionManager")
    public DataSourceTransactionManager gas_silverboltTransactionManager() {
        return new DataSourceTransactionManager(gas_silverboltDataSource());
    }

    @Bean(name = "gas_silverboltSqlSessionFactory")
    public SqlSessionFactory gas_silverboltSqlSessionFactory(@Qualifier("gas_silverboltDataSource") DataSource gas_silverboltDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(gas_silverboltDataSource);
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }
}
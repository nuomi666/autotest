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
@MapperScan(basePackages = "dal.dao.gas_user", sqlSessionFactoryRef = "gas_userSqlSessionFactory", nameGenerator =
		MultiBeanNameGenerator.class)
public class Gas_userDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.gas_user.url}")
    private String url;

    @Value("${ds.gas_user.username}")
    private String username;

    @Value("${ds.gas_user.password}")
    private String password;

    @Value("${ds.gas_user.driverClassName}")
    private String driverClassName;

    @Bean(name = "gas_userDataSource")
    public DataSource gas_userDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "gas_userTransactionManager")
    public DataSourceTransactionManager gas_userTransactionManager() {
        return new DataSourceTransactionManager(gas_userDataSource());
    }

    @Bean(name = "gas_userSqlSessionFactory")
    public SqlSessionFactory gas_userSqlSessionFactory(@Qualifier("gas_userDataSource") DataSource gas_userDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(gas_userDataSource);
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }
}
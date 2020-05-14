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

/**
 * @author autotest
 * Created on 2018/03/21.
 */
@Configuration
@MapperScan(basePackages = "dal.dao.rap", sqlSessionFactoryRef = "rapSqlSessionFactory", nameGenerator = MultiBeanNameGenerator.class)
public class RapDataSourceConfig extends DruidBaseConfig {

    @Value("${ds.rap.url}")
    private String url;

    @Value("${ds.rap.username}")
    private String username;

    @Value("${ds.rap.password}")
    private String password;

    @Value("${ds.rap.driverClassName}")
    private String driverClassName;

    @Bean(name = "rapDataSource")
    public DataSource rapDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return setDataSource(dataSource, url, username, password, driverClassName);
    }

    @Bean(name = "rapTransactionManager")
    public DataSourceTransactionManager rapTransactionManager() {
        return new DataSourceTransactionManager(rapDataSource());
    }

    @Bean(name = "rapSqlSessionFactory")
    public SqlSessionFactory rapSqlSessionFactory(@Qualifier("rapDataSource") DataSource rapDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(rapDataSource);
//        Resource[] resource = new PathMatchingResourcePatternResolver().getResources("dal/mapping/rap/TbProjectMapper.xml");
//        sessionFactory.setMapperLocations(resource);
        return sessionFactory.getObject();
    }
}
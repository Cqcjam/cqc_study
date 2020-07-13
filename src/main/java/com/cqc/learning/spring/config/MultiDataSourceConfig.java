package com.cqc.learning.spring.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.sql.XADataSource;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.config
 * @date 2020/7/13-17:39
 */
@Configuration
public class MultiDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.a")
    public XADataSource druidSourceA(){
        return new DruidXADataSource();
    }

    @Bean
    public DataSource dataSourceA(){
        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setXaDataSource(druidSourceA());
        return dataSource;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.b")
    public XADataSource druidSourceB(){
        return new DruidXADataSource();
    }

    @Bean
    public DataSource dataSourceB(){
        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setXaDataSource(druidSourceB());
        return dataSource;
    }
}

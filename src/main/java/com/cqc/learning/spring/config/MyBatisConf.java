package com.cqc.learning.spring.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * MyBatis配置
 */
public abstract class MyBatisConf {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // 注意：如果这里使用了scan模式，那么Mapper代码不能在其他工程中
        mapperScannerConfigurer.setBasePackage("com.cqc.learning");
        mapperScannerConfigurer.setAnnotationClass(Mapper.class);
        return mapperScannerConfigurer;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 不使用scan模式，避免sb打包导致无法查询到class的异常
        sqlSessionFactoryBean.setTypeHandlers(new TypeHandler[]{new DefaultTypeHandler.BooleanHandler(),
                new DefaultTypeHandler.ListTypeHandler()});
        return sqlSessionFactoryBean;
    }
}
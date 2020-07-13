package com.cqc.learning.spring.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.util.Objects;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.config
 * @date 2020/7/13-17:34
 */
@Configuration
@MapperScan(basePackages = "com.cqc.learning.spring.dao.a.**", sqlSessionFactoryRef = "sqlSessionFactoryA")
public class ADataSourceMybatisConfig {

    /**
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactoryA(@Qualifier("dataSourceA") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(
                ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "mapper/a/*xml"));
        Objects.requireNonNull(sqlSessionFactoryBean.getObject()).getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate sessionTemplateA(@Qualifier("sqlSessionFactoryA") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

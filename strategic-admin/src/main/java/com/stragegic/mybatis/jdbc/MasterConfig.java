package com.stragegic.mybatis.jdbc;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;


/*@Configuration
@MapperScan(basePackages = "com.*.service", sqlSessionTemplateRef = "jmSqlSessionTemplate")*/
public class MasterConfig {

 /*   @Bean(name = "jmDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource getJmDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jmSqlSessionFactory")
    @Primary
    public SqlSessionFactory jmSqlSessionFactory(@Qualifier("jmDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/mapper/*.xml"));
        return bean.getObject();// 设置mybatis的xml所在位置
    }

    @Bean("jmSqlSessionTemplate")
    // 表示这个数据源是默认数据源
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(
            @Qualifier("jmSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }*/

}

package com.stragegic.mybatis.jdbc;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/*
@Configuration
@MapperScan(basePackages = "com.*.jm", sqlSessionFactoryRef = "SlaveSqlSessionFactory")//basePackages:接口文件的包路径
*/
public class SlaveConfig {
/*    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource getSecondaryDataSource() {
        return DataSourceBuilder.create().build();
    }*/
/*    @Bean(name = "SlaveSqlSessionFactory")
    public SqlSessionFactory secondarySqlSessionFactory(@Qualifier("slaveDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/jmmapper/*.xml"));
        return bean.getObject();// 设置mybatis的xml所在位置
    }
    @Bean("SlaveSqlSessionTemplate")
    public SqlSessionTemplate secondarySqlSessionTemplate(
            @Qualifier("SlaveSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }*/
}

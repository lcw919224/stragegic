package com.stragegic.config.druid;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * Mybatis支持*匹配扫描包
 *
 * @author ruoyi
 */
@Configuration
@MapperScan(basePackages = {"com.stragegic.**"}, sqlSessionTemplateRef = "sqlSessionTemplate")
public class MyBatisConfig {

    @Bean(name = "masterSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory( DataSource dataSource)  throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/mapper/*.xml")
        );
        return bean.getObject();

    }

    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate( @Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }
}
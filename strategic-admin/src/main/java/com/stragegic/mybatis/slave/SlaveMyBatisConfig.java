package com.stragegic.mybatis.slave;

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
@MapperScan(basePackages = {"com.*.jm.mapper"}, sqlSessionTemplateRef = "slaveSessionTemplate")
public class SlaveMyBatisConfig {

    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("slaveDataSource") DataSource dataSource)  throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/jmmapper/*.xml")
        );
        return bean.getObject();
    }

    @Bean("slaveSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate( @Qualifier("slaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }

}
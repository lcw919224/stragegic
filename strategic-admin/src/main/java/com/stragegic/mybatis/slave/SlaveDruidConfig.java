package com.stragegic.mybatis.slave;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.stragegic.mybatis.slave.properties.SlaveDruidProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * druid 配置多数据源
 * 
 * @author ruoyi
 */
@Configuration
public class SlaveDruidConfig
{
    @Bean(name = "slaveDataSource")
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource masterDataSource(SlaveDruidProperties druidProperties)
    {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return druidProperties.dataSource(dataSource);
    }

}

package com.vienna.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author tonyhui
 * @since 16/9/8
 */
@Configuration
public class ViennaDBConfig {

    /**
     * 创建数据源
     *
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "db.vienna")
    public DataSource dataSource() {
        return new DruidDataSource();
    }


    /**
     * 创建数据源事务管理器
     *
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }
}
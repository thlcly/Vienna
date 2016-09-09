package com.vienna.config;

import org.jooq.ConnectionProvider;
import org.jooq.SQLDialect;
import org.jooq.TransactionProvider;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

/**
 * @author tonyhui
 * @since 16/9/8
 */
@Configuration
public class JooqConfig {

    /**
     * 配置jooq使用的连接池
     *
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceConnectionProvider dataSourceConnectionProviderV(
            @Autowired DataSource dataSource) {
        return new DataSourceConnectionProvider(
                new TransactionAwareDataSourceProxy(dataSource));
    }

    /**
     * 使用spring管理jooq的事务
     *
     * @param txManager
     * @return
     */
    @Bean
    public SpringTransactionProvider transactionProviderV(
            @Autowired DataSourceTransactionManager txManager) {
        return new SpringTransactionProvider(txManager);
    }

    /**
     * 创建jooq的上下文
     *
     * @param connectionProvider
     * @param transactionProvider
     * @return
     */
    @Bean
    public DefaultDSLContext dslContext(@Qualifier("dataSourceConnectionProviderV") DataSourceConnectionProvider connectionProvider,
                                 @Qualifier("transactionProviderV") SpringTransactionProvider transactionProvider) {
        return new DefaultDSLContext(configuration(connectionProvider, transactionProvider));
    }

    private DefaultConfiguration configuration(ConnectionProvider connectionProvider, TransactionProvider transactionProvider) {
        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.setSQLDialect(SQLDialect.MYSQL);
        configuration.set(connectionProvider);
        configuration.set(transactionProvider);
        return configuration;
    }
}

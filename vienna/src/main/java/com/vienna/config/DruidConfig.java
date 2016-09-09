package com.vienna.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tonyhui
 * @since 16/9/8
 */
@Configuration
public class DruidConfig {

    @Value("${druid.stat.login.username}")
    private String loginUsername;

    @Value("${druid.stat.login.password}")
    private String loginPassword;

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("loginUsername", loginUsername);
        reg.addInitParameter("loginPassword", loginPassword);

        return reg;
    }
}

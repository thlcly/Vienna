package com.vienna.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tonyhui
 * @since 16/9/11
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "druid.stat.login")
public class DruidProperties {
    private String username;
    private String password;
}

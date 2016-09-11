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
@ConfigurationProperties(prefix = "db.vienna")
public class ViennaDBProperties {
    private String url;
    private String username;
    private String password;
    private Integer initialSize;
    private Integer minIdle;
    private Integer maxActive;
    private String filters;
}

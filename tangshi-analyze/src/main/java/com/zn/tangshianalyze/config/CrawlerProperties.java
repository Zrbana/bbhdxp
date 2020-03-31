package com.zn.tangshianalyze.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * Author: yuisma
 * Created: 2020/02/15
 */
@ConfigurationProperties(prefix = "crawler")
@Component
@Data
public class CrawlerProperties {
    
    private String base;
    
    private String path;
    
    private Integer thread;
}


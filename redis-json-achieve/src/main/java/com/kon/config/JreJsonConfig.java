package com.kon.config;

import com.redislabs.modules.rejson.JReJSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * note
 *
 * @author kon, created on 2021/12/21T14:06.
 * @version 1.0.0-SNAPSHOT
 */
@Configuration
public class JreJsonConfig {

    @Value("${redis.host}")
    String host;

    @Value("${redis.port}")
    Integer port;

    @Bean
    public JReJSON jReJson() {
        if (StringUtils.hasLength(host) && null != port && 0 <= port && port <= 65535) {
            return new JReJSON(this.host, this.port);
        }
        throw new IllegalArgumentException("host [" + host + "] or port [" + port + "] is error!");
    }

}

package com.my.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/11/17
 */
@Configuration
public class RestTemplateConfig {

    /**
     * 超时时间30秒
     */
    private static final int TIME_OUT = 1000 * 30;

    @Bean
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        // 链接超时1分钟
        requestFactory.setConnectTimeout(TIME_OUT);
        requestFactory.setReadTimeout(TIME_OUT);
        return new RestTemplate(requestFactory);
    }


}

package com.app.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wailm.yousif on 2/7/17.
 */
@Configuration
public class FilterRegistrationUtil {
    @Bean
    public FilterRegistrationBean restSecutiryFilter()
    {
        FilterRegistrationBean registration = new FilterRegistrationBean(new AuthFilter());

        //registration.addUrlPatterns("/*");

        registration.addUrlPatterns("/rest/bp/*");

        return registration;
    }
}
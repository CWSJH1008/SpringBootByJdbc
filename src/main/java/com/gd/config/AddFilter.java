package com.gd.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;

/**
 * Created by Administrator on 2020/2/1.
 */
@Configuration
public class AddFilter {
    @Bean
    public FilterRegistrationBean addRegisFilter(){
        FilterTest filterTest=new FilterTest();
        FilterRegistrationBean bean=new FilterRegistrationBean(filterTest);
        return bean;
    }
}

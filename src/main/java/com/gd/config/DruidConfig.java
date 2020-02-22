package com.gd.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.gd.jdbc.ControllerTest;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/1/28.
 */
@Configuration
public class DruidConfig {


    private ServletRegistrationBean servletRegistrationBean;
    private FilterRegistrationBean filterRegistrationBean;

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druid(){
        return new DruidDataSource();
    }
   /* @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource c3p0(){
        return new ComboPooledDataSource();
    }*/
   //配置一个管理后台的Servelet，配置druid的监控
    @Bean
    public ServletRegistrationBean statViewServlet(){
        servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initMaps=new HashMap<>();
        initMaps.put("loginUsername","admin");
        initMaps.put("loginPassword","admin");
        initMaps.put("allow","");//默认允许所有
        initMaps.put("deny","");//拒绝访问
        servletRegistrationBean.setInitParameters(initMaps);
        return servletRegistrationBean;
    }
    //配置一个web 监控拦截器 filter
    @Bean
    public FilterRegistrationBean statFilter(){
        filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        Map<String,String> initMaps=new HashMap<>();
        initMaps.put("exclusions","*.js,*.css,/druid/*");
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.setInitParameters(initMaps);
        return filterRegistrationBean;
    }
}
































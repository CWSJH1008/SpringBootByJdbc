package com.gd.config;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2020/2/1.
 */
public class FilterTest extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse)response;
        //"*"存在风险，建议指定可信任的域名来接收响应信息，如"http://www.sosoapi.com"
        resp.addHeader("Access-Control-Allow-Origin", "http://www.sosoapi.com");
        //如果存在自定义的header参数，需要在此处添加，逗号分隔
        resp.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, "
                + "If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, "
                + "Content-Type, X-E4M-With");
        resp.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        resp.addHeader("Access-Control-Allow-Credentials", "true");

        chain.doFilter(request, response);
    }


}

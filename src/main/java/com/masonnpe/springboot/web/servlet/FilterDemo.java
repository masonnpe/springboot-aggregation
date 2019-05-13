//package com.masonnpe.springboot.web.servlet;
//
//import org.springframework.util.StringUtils;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebListener;
//import javax.servlet.http.HttpFilter;
//import java.io.IOException;
//
//@WebFilter
//public class FilterDemo extends HttpFilter {
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String name = (String)request.getAttribute("name");
//        if(StringUtils.isEmpty(name)){
//            throw new ServletException("name is empty");
//        }
//
//    }
//}

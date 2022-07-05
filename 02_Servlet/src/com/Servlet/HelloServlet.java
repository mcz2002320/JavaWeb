package com.Servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/*
    第一个Servlet程序
 */
public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1 构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化方法");

        System.out.println("HelloServlet程序的别名是："+servletConfig.getServletName());
        //可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是："+servletConfig.getServletName());
        //获取初始参数into-param
        System.out.println("初始化参数username的值是："+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是："+servletConfig.getInitParameter("url"));
        //
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 Servlet方法 == HelloSevrlen被访问");

        //类型转换
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        //获取请求方式
        String method = httpServletRequest.getMethod();

        System.out.println(method);


        if ("GET".equals(method)){
           doget();
        }else if ("POST".equals(method)){
            dopost();
        }
    }

    /*
        做get请求的操作
     */
    public void doget(){
        System.out.println("get请求");
        System.out.println("get请求");
    }

    /*
        post请求的操作
     */
    public void dopost(){
        System.out.println("post请求");
        System.out.println("post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 销毁方法");
    }
}

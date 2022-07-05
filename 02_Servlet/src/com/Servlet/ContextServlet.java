package com.Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取web.xml中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();

        String username = context.getInitParameter("username");
        System.out.println("context-param参数username的值是："+username);
        String password = context.getInitParameter("password");
        System.out.println("context-param参数password的值是："+password);

        //2.获取当前工程路径
        System.out.println("当前工程路径："+context.getContextPath());

        //3.获取工程部署后在服务器硬盘上的绝对路径
        System.out.println("工程部署路径"+context.getRealPath("/"));
    }
}

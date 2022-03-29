package com.yuanstack.bp.springsource.introduction.v5_cached.servlet;

import com.yuanstack.bp.springsource.introduction.v5_cached.factory.BeanFactoryV5;
import com.yuanstack.bp.springsource.introduction.v5_cached.service.DemoServiceV5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hansiyuan
 * @date 2022年03月29日 23:04
 */
@WebServlet(urlPatterns = "/demo4")
public class DemoServletV5 extends HttpServlet {

    DemoServiceV5 demoService = (DemoServiceV5) BeanFactoryV5.getBean("demoServiceV5");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll().toString());
    }
}

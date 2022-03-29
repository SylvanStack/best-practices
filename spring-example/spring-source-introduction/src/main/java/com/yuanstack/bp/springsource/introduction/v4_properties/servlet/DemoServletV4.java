package com.yuanstack.bp.springsource.introduction.v4_properties.servlet;

import com.yuanstack.bp.springsource.introduction.v4_properties.factory.BeanFactoryV4;
import com.yuanstack.bp.springsource.introduction.v4_properties.service.DemoServiceV4;

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
public class DemoServletV4 extends HttpServlet {

    DemoServiceV4 demoService = (DemoServiceV4) BeanFactoryV4.getBean("demoServiceV4");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll().toString());
    }
}

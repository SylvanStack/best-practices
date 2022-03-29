package com.yuanstack.bp.springsource.introduction.v3_reflect.servlet;


import com.yuanstack.bp.springsource.introduction.v3_reflect.factory.BeanFactoryV3;
import com.yuanstack.bp.springsource.introduction.v3_reflect.service.DemoServiceV3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hansiyuan
 * @date 2022年03月29日 22:18
 */
@WebServlet(urlPatterns = "/demo3")
public class DemoServletV3 extends HttpServlet {

    DemoServiceV3 demoService = BeanFactoryV3.getDemoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println(demoService.findAll().toString());
    }
}

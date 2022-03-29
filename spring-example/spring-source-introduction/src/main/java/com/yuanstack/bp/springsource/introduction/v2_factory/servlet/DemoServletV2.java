package com.yuanstack.bp.springsource.introduction.v2_factory.servlet;

import com.yuanstack.bp.springsource.introduction.v2_factory.factory.BeanFactoryV2;
import com.yuanstack.bp.springsource.introduction.v2_factory.service.DemoServiceV2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hansiyuan
 * @date 2022年03月29日 22:05
 */
@WebServlet(urlPatterns = "/demo2")
public class DemoServletV2 extends HttpServlet {

    DemoServiceV2 demoServiceV2 = BeanFactoryV2.getDemoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println(demoServiceV2.findAll().toString());
    }
}

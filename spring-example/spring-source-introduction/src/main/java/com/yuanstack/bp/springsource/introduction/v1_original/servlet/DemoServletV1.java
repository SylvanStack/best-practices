package com.yuanstack.bp.springsource.introduction.v1_original.servlet;

import com.yuanstack.bp.springsource.introduction.v1_original.service.DemoServiceV1;
import com.yuanstack.bp.springsource.introduction.v1_original.service.impl.DemoServiceV1Impl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hansiyuan
 * @date 2022年03月29日 22:05
 */
@WebServlet(urlPatterns = "/demo1")
public class DemoServletV1 extends HttpServlet {

    DemoServiceV1 demoService = new DemoServiceV1Impl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println(demoService.findAll().toString());
    }
}

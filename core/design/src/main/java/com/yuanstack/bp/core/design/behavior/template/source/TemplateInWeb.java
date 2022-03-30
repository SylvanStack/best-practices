package com.yuanstack.bp.core.design.behavior.template.source;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 模版模式在Java Web中的应用
 * @author: hansiyuan
 * @date: 2022/3/30 10:59 AM
 */
public class TemplateInWeb {
    public static void main(String[] args) {
        // 模版模式在Servlet中的应用(扩展)
        templateInHttpServlet();
    }

    private static void templateInHttpServlet() {
        // HelloServlet 在不用修改 Servlet 框架源码的情况下，将业务代码通过扩展点镶嵌到框架中执行。
        // HelloService
    }
}

class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello World.");
    }
}

class HelloService {
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request;
        HttpServletResponse response;
        if (!(req instanceof HttpServletRequest &&
                res instanceof HttpServletResponse)) {
            throw new ServletException("non-HTTP request or response");
        }
        request = (HttpServletRequest) req;
        response = (HttpServletResponse) res;
        service(request, response);
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
//        if (method.equals(METHOD_GET)) {
//            doGet(req, resp);
//        } else if (method.equals(METHOD_HEAD)) {
//            doHead(req, resp);
//        } else if (method.equals(METHOD_POST)) {
//            doPost(req, resp);
//        } else if (method.equals(METHOD_PUT)) {
//            doPut(req, resp);
//        } else if (method.equals(METHOD_DELETE)) {
//            doDelete(req, resp);
//        } else if (method.equals(METHOD_OPTIONS)) {
//            doOptions(req, resp);
//        } else if (method.equals(METHOD_TRACE)) {
//            doTrace(req, resp);
//        } else {
//            String errMsg = lStrings.getString("http.method_not_implemented");
//            Object[] errArgs = new Object[1];
//            errArgs[0] = method;
//            errMsg = MessageFormat.format(errMsg, errArgs);
//            resp.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, errMsg);
//        }
    }
}

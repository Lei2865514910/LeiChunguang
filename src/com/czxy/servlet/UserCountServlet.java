package com.czxy.servlet;

import cn.itcast.servlet.BaseServlet;

import java.io.IOException;

/**
 * @author lenovo
 * @version v 1.0
 * @date 2019/3/19
 */
public class UserCountServlet extends BaseServlet {
    public void show() throws IOException {
        int loginCount = (int) this.getServletContext().getAttribute("loginCount");
        this.getResponse().getWriter().write("恭喜你 你的登录名次是："+loginCount);
    }
}

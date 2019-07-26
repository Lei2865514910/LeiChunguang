package com.czxy.servlet;

import cn.itcast.servlet.BaseServlet;
import cn.itcast.vcode.VerifyCode;

import java.io.IOException;

/**
 * @author lenovo
 * @version v 1.0
 * @date 2019/3/19
 */
public class VcServlet extends BaseServlet {
    public void getVcs() throws IOException {
        //1.创建一个验证码对象
        VerifyCode vf = new VerifyCode();
        //2.获取图片响应回去
        VerifyCode.output(vf.getImage(),this.getResponse().getOutputStream());
    }
}

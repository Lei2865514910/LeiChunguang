package com.czxy.servlet;

import cn.itcast.servlet.BaseServlet;
import cn.itcast.xml.XmlUtils;
import com.czxy.domain.User;
import com.czxy.utils.MyUtil;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @author lenovo
 * @version v 1.0
 * @date 2019/3/19
 */
public class LoginServlet extends BaseServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        //创建一个loginCount
        int loginCount=0;
        //存储到公共区域
        this.getServletContext().setAttribute("loginCount",loginCount);
    }

    public void login() throws IOException {
        User user = toBean(User.class);
        //判断 用户名和密码是否正确

        //从xml读取 用户的信息集合
        List<User> list = XmlUtils.readAll(MyUtil.userXmlName, User.class);
        //判断页面传递过来的用户名和密码是否在集合中
        boolean flag= false;
        for (User u : list) {
            if (u.getUsername().equals(user.getUsername())&& u.getPwd().equals(user.getPwd())){
                flag=true;
                break;
            }
        }
        if (flag){
            //3.如果正确就告知浏览器 3秒后跳转到新页面 加一个响应头
            //获取loginCount++ 放回去
            int loginCount = (int) this.getServletContext().getAttribute("loginCount");
            loginCount++;
            this.getServletContext().setAttribute("loginCount",loginCount);

            this.getResponse().addHeader("Refresh","3;url=http://localhost:8080/ucs?method=show");

            this.getResponse().getWriter().write("恭喜你 登录成功了  嘿嘿 3秒钟后 跳转到新页面");
        }else {
            //4.如果登录失败 则直接提示登陆失败
            this.getResponse().getWriter().write("登录失败了 哈哈哈");
        }
    }
}

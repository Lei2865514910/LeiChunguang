package com.czxy.servlet;

import cn.itcast.servlet.BaseServlet;
import cn.itcast.xml.XmlUtils;
import com.czxy.domain.Person;
import com.czxy.utils.MyUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author lenovo
 * @version v 1.0
 * @date 2019/3/19
 */
public class RegisterServlet extends BaseServlet {

    public String  changeCharactor(String s,String srcCode,String destCode) throws UnsupportedEncodingException {
        //先把 s使用 老的编码格式 解码
        byte[] data = s.getBytes(srcCode);
        // 把 s解码得到的数据 以新的编码方式编码并返回
        return  new String(data,destCode);
    }

    public void regist() throws IOException {

        //1.获取页面传递过来的参数
        Person person = toBean(Person.class);
        //重新编码--->  只 针对于  表单使用 get方式 提交的时候  出现乱码情况的解决.
        person.setName(changeCharactor(person.getName(),"ISO-8859-1","UTF-8"));
        //2.读取xml 拿到里面的用户数据
        List<Person> list = XmlUtils.readAll(MyUtil.personName,Person.class);
        //3.判断 页面传递的电话号 是否在xml中 如果在则不让注册 并提示
        //否则 让注册 同时把信息追加到xml中 并提示

        boolean flag = false;
        for (Person p : list) {
            if (p.getPhone().equals(person.getPhone())){
                flag=true;
                break;
            }
        }
        if (flag){
            this.getResponse().getWriter().write("注册失败 手机号已经被注册了");
        }else {
            XmlUtils.write(MyUtil.personName,person,true);
            this.getResponse().getWriter().write("恭喜你 注册成功了");
        }



    }
}

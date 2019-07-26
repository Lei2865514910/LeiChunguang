package com.czxy.utils;

import cn.itcast.xml.XmlUtils;
import com.czxy.domain.Person;
import com.czxy.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lenovo
 * @version v 1.0
 * @date 2019/3/19
 */
public class MyUtil {
    public static final String userXmlName="D:\\BigData\\Day\\XML\\user.xml";
    public static final String personName="D:\\BigData\\Day\\XML\\person.xml";

    public void savePerson(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("1383838438","123","zhangsanfeng"));
        list.add(new Person("13598582190","123","lisiguang"));
        list.add(new Person("12345678910","123","wangbadan"));
        XmlUtils.write(personName,list);
        System.out.println("保存好了");
    }





    @Test
    public void saveData(){
        User u1 = new User("zhangsan","123");
        User u2 = new User("lisi","456");
        User u3 = new User("wangwu","789");
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);

        XmlUtils.write(userXmlName,list);
        System.out.println("数据保存完毕");

    }
}

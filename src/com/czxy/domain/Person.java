package com.czxy.domain;

/**
 * @author lenovo
 * @version v 1.0
 * @date 2019/3/19
 */
public class Person {
    private String phone;
    private String pwd;
    private String name;

    public Person() {
    }

    public Person(String phone, String pwd, String name) {
        this.phone = phone;
        this.pwd = pwd;
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

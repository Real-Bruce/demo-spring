package cn.bruce.service.impl;

import cn.bruce.service.AccountService;

import java.util.Date;

public class AccountServiceImpl1 implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public void setNnnname(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount (){
        System.out.println("Service创建的账户保存了");
    }

    public void show (){
        System.out.println(name + " "+ age + " " + birthday);
    }

}

package cn.bruce.service.impl;

import cn.bruce.service.AccountService;

import java.util.Date;

public class AccountServiceImpl implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount (){
        System.out.println("Service创建的账户保存了");
    }

    public void show (){
        System.out.println(name + " "+ age + " " + birthday);
    }

}

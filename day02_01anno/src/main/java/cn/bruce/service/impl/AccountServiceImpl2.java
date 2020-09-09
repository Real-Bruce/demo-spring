package cn.bruce.service.impl;

import cn.bruce.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service(value = "accountService2")
public class AccountServiceImpl2 implements AccountService {

    @Value("Bruce")
    private String[] strs;
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;
    private Properties properties;

    public AccountServiceImpl2() {
    }

    public void saveAccount (){
        System.out.println("Service创建的账户保存了");
    }

    public void show (){
        System.out.println("hello");
        System.out.println(Arrays.toString(strs));
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
        System.out.println(properties);
    }

}

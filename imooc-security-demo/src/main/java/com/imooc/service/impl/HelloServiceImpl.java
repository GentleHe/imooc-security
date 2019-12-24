package com.imooc.service.impl;

import com.imooc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author 何国锋
 * @date 2019-12-21 18:09
 */
@Service
public class HelloServiceImpl implements HelloService {


    @Override
    public String greeting(String name) {

        System.out.println("greeting!");
        return "Hello, " + name;
    }
}

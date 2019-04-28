package com.hyj.framework.web.controller;


import org.springframework.stereotype.Component;

/**
 * @author huyuanjia
 * @date 2019/4/28 15:16
 */
@Component
public class AopTest {

    public String testDemo(String s){
        System.out.println(s);
        return s;
    }
}

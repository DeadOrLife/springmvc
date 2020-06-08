package com.wz.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @DESCRIPTION new class
 * @AUTHOR: jamesbean
 * @DATE: 2020/5/21 12:38 上午
 */
@Controller
public class HelloWord {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello world");
        return "success";
    }


}

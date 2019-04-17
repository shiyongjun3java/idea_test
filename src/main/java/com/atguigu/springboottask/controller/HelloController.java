package com.atguigu.springboottask.controller;

import com.atguigu.springboottask.service.AsyncService;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunny
 * @title: HelloController
 * @date 2019-04-1617:13
 */
@RestController
public class HelloController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/hello")
    public Object hello() {
        asyncService.hello();
        return "success";
    }
}

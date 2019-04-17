package com.atguigu.springboottask.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author sunny
 * @title: AsyncService
 * @date 2019-04-1617:08
 */
@Service
public class AsyncService {

    @Async
    public void hello(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据处理中.....");
    }
}

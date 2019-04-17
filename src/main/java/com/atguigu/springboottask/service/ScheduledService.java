package com.atguigu.springboottask.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author sunny
 * @title: ScheduleService
 * @date 2019-04-1617:27
 */
@Service
public class ScheduledService {

    /**
     * 秒,分,时,日,月,周几
     */
    @Scheduled(cron = "0 * * * * MON-SAT")
    public void hello() {
        System.out.println("定时任务执行...");

    }
}

package com.xlx.simpledemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author xieluxin
 * @Date 2020/3/18 0:37
 * @Version 1.0
 */
@Service
@Slf4j
public class TestService2 {
    public void testTrace() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("测试日志4");
    }
}
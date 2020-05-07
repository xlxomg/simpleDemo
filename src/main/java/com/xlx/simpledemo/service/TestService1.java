package com.xlx.simpledemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;

/**
 * @Author xieluxin
 * @Date 2020/3/18 0:36
 * @Version 1.0
 */
@Service
@Slf4j
public class TestService1 implements TestService{
    @Resource
    TestService2 testService2;
    @Override
    public void testTrace() {
        log.info("测试日志2");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test();
    }
    private void  test(){
        log.info("测试日志3");
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testService2.testTrace();
    }
}
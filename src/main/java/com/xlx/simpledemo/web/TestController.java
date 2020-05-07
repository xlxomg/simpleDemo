package com.xlx.simpledemo.web;

import com.xlx.simpledemo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author xieluxin
 * @Date 2020/3/18 0:16
 * @Version 1.0
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {
    @Resource
    private TestService testService;

    @RequestMapping("testTrace")
    public Object testTrace(){
        log.info("测试日志1");
        testService.testTrace();
        return "OK~~~";
    }
    @RequestMapping("testOk")
    public Object testOk(){
        return "OK";
    }
}
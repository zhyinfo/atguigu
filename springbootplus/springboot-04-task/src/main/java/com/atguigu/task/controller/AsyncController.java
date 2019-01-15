package com.atguigu.task.controller;

import com.atguigu.task.service.AsyncService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/hello")
    public String hello(){
        asyncService.hello();
        return "success";
    }
    
    @GetMapping("/async")
    public String asyncRtn() throws InterruptedException, ExecutionException {
    	
    	Future<String> future = asyncService.rtnAsync();
    	
    	Thread.sleep(2000);
    	System.out.println("do other thing...");

    	
    	while (true) {  			//这里使用了循环判断，等待获取结果信息
	        if (future.isDone()) {  //判断是否执行完毕
	            System.out.println("Result from asynchronous process - " + future.get());
	            break;
	        }
	        System.out.println("Continue doing something else. ");
	        Thread.sleep(1000);
	    }
    	
    	return "success";
    }
}

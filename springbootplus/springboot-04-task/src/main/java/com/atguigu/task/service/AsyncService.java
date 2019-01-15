package com.atguigu.task.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    //告诉Spring这是一个异步方法
    @Async
    public void hello(){
        try {
            Thread.sleep(5000); //模拟调用第三方系统
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中...");
    }
    
	@Async
	public Future<String> rtnAsync() {
	    System.out.println("Execute async method.. - " + Thread.currentThread().getName());
	    try {
	        Thread.sleep(5000);
	        return new AsyncResult<String>("hello world !!!");
	    } catch (InterruptedException e) {
	        //
	    }
	 
	    return null;
	}

}


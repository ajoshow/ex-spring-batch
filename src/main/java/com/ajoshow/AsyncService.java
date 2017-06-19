package com.ajoshow;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @author chiahung.chu on 2017/6/19.
 */
@Service
public class AsyncService {

    @Async
    public String longTask1(){
	return longTask(5) + " is finished";
    }

    @Async
    public CompletableFuture<String> longTask2(){
	return CompletableFuture.completedFuture(longTask(5) + " is finished");
    }

    @Async
    public DeferredResult<String> longTask3(DeferredResult<String> deferredResult){
        longTask(5);
	deferredResult.setResult("completed");
	return deferredResult;
    }

    private String longTask(int sec){
	String id = UUID.randomUUID().toString().substring(0, 8);
	for(int i=0; i<sec; i++){
	    try {
		Thread.sleep(1000);
		System.out.println("[" + id + "] running task ---> " + i);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	System.out.println("[" + id + "] is completed.");
	return id;
    }

}

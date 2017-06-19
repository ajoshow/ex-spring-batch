package com.ajoshow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;

/**
 * @author Andy on 2017/6/17.
 */
@Controller
@RequestMapping
public class AsyncController {

    @Autowired
    private AsyncService svc;

    @RequestMapping(method = RequestMethod.GET, value = "/async1")
    @ResponseBody
    public String async1(){
        // response immediately
        return svc.longTask1();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/async2")
    @ResponseBody
    public CompletableFuture<String> async2(){
        // response until task finish.
        return svc.longTask2();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/async2-2")
    @ResponseBody
    public ResponseEntity async2_2(){
        // response immediately
        return new ResponseEntity(svc.longTask2(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/async3")
    @ResponseBody
    public DeferredResult<String> async3(){
        // response immediately
        return svc.longTask3(new DeferredResult<>());
    }
}

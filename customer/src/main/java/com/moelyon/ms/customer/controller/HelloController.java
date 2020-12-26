package com.moelyon.ms.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.moelyon.ms.api.service.SayHelloService;
import com.moelyon.ms.api.service.WordListService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * hello
 *
 * @author : wlt
 * @date : 2020-12-22 17:33
 **/
@RestController
@RequestMapping("hello")
public class HelloController {

    @DubboReference
    SayHelloService sayHelloService;
    @DubboReference
    WordListService wordListService;
    @GetMapping("/{name}")
    public String hello(@PathVariable(name = "name") String name){
        return  sayHelloService.sayhello(name);
    }

    @GetMapping("word")
    public String wordList(@RequestParam("word") String word){

        List<String> chars = wordListService.getCharList(word);
        Collections.reverse(chars);
        return String.join("",chars);
    }
}

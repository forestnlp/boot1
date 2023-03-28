package com.demo.controller;

import com.demo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "HelloApi")
public class Hello {

    @GetMapping("/hello")
    public String sayHello(){
        return "helloworld!";
    }

    @RequestMapping("/user")
    @ApiOperation(value = "用户接口")
    public String getUser(@RequestBody @Valid User user){
        return user.toString();
    }
}

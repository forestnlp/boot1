package com.demo.controller;

import com.demo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@Api(tags = "HelloApi 接口")
public class Hello {

    @GetMapping("/hello")
    public String sayHello(){
        return "helloworld!";
    }

    @PostMapping("/user")
    @ApiOperation(value = "用户提交接口")
    public String getUser(@RequestBody @Valid User user){
        return user.toString();
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "根据id获取用户接口")
    public User getUserById(@PathVariable int id){
        User zhangsan = new User(id, "zhangsan", 18, "zhangsan@sina.com", LocalDate.now());
        return zhangsan;
    }
}

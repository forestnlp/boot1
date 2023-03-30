package com.demo.controller;

import com.demo.dao.UserRepository;
import com.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
//@Api("HelloApi 接口")
public class Hello {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String sayHello(){
        return "helloworld!";
    }

    @PostMapping("/user")
    //@ApiOperation(value = "用户提交接口")
    public String getUser(@RequestBody @Valid User user){
        return user.toString();
    }

    @GetMapping("/user/{id}")
    //@ApiOperation(value = "根据id获取用户接口")
    public User getUserById(@PathVariable int id){
        User zhangsan = userRepository.findById(id).get();
        return zhangsan;
    }
}

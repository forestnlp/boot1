package com.demo.controller;

import com.demo.dao.UserRepository;
import com.demo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
//@RestController
//@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @ApiOperation("用id获取用户")
    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return userRepository.findById(id).get();
    }

    @ApiOperation("创建用户")
    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @ApiOperation("更新用户")
    @PostMapping
    public User update(@PathVariable User user) {
        return userRepository.save(user);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}

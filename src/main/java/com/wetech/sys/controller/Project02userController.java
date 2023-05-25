package com.wetech.sys.controller;

import com.wetech.common.vo.Result;
import com.wetech.sys.entity.Project02;
import com.wetech.sys.entity.Project02user;
import com.wetech.sys.service.IProject02userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project02user")
public class Project02userController {

@Autowired
    private IProject02userService iProject02userService;

    @GetMapping("/adds")
    public Result<List<Project02user>> userselectAll(){
        List<Project02user> list = iProject02userService.userselectAll();
        return Result.success(list,"查询成功");
    }


    @PostMapping("/loginuser")
    public Result<Map<String,Object>> login(@RequestBody Project02user project02user) {
        Map<String, Object> data = iProject02userService.userlogin(project02user);
        if (data != null) {
            //存入redis

            //返回数据
            return Result.success(data);
        }
        return  Result.fail(20002,"用户名或者密码错误");
    }

    @PostMapping("/logoutuser")
    public Result<?> logout(@RequestHeader("X-Token")String token){
        iProject02userService.userlogout(token);
        return Result.success();
    }






}


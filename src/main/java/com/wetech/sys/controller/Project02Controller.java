package com.wetech.sys.controller;
import com.wetech.common.vo.Result;
import com.wetech.sys.entity.Project02;
import com.wetech.sys.service.Project02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//
//@RestController
//@RequestMapping("/project02")
//public class Project02Controller {
//    @Autowired
//    private Project02Service project02Service;
//
//    @PostMapping("/add")
//   public ResponseEntity<String> createUser(@RequestBody Project02 project02) {
//        project02Service.selectByUsernameAndPassword(project02);
//       return ResponseEntity.ok("保存成功");
//    }
////    @GetMapping("/add")
////    public Result<List<Project02>> selectByUsernameAndPassword(){
////        List<Project02> list = project02Service.list();
////        return new Result<>(20000,"success",list);
////    }
//
//}
@RestController
@RequestMapping("/project02")
//@CrossOrigin
public class Project02Controller {
    @Autowired
    private Project02Service project02Service;
//
    @GetMapping("/add")
    public Result<List<Project02>> selectAll(){
        List<Project02> list = project02Service.selectAll();
        return Result.success(list,"查询成功");
    }

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody Project02 project02) {
        Map<String, Object> data = project02Service.login(project02);
        if (data != null) {
            //存入redis

            //返回数据
            return Result.success(data);
        }
        return  Result.fail(20002,"用户名或者密码错误");
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("X-Token")String token){
        project02Service.logout(token);
        return Result.success();
    }
}



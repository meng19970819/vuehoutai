package com.wetech.sys.service;

import com.wetech.sys.entity.Project02;
import com.wetech.sys.entity.Project02user;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface IProject02userService {
        List<Project02user> userselectAll();
        Map<String, Object> userlogin(Project02user project02user);
        void userlogout(String token);
}

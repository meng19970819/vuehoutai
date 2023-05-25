package com.wetech.sys.service.impl;

import com.wetech.sys.entity.Project02;
import com.wetech.sys.mapper.Project02Mapper;
import com.wetech.sys.service.Project02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class Project02Servicelmpl implements Project02Service {
    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    private Project02Mapper project02Mapper;

    @Override
    public Map<String, Object> login(Project02 project02) {
        Project02 result = project02Mapper.selectByUsernameAndPassword(project02.getUsername(), project02.getPassword());

        if (result != null) {
            // 查询成功，生成token并将用户信息存入Redis
            // ...
            String key = "user" + UUID.randomUUID();
            //存入redis
            result.setPassword(null);
            redisTemplate.opsForValue().set(key,result,30, TimeUnit.MINUTES);

            //返回数据
            Map<String, Object> data = new HashMap<>();
            data.put("token",key);
            return data;
        }

        return null;
    }

    @Override
    public List<Project02> selectAll() {
        return project02Mapper.selectAll();
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }
}


//@Service
//public class Project02Servicelmpl implements Project02Service {
//    @Autowired
//    private Project02Mapper project02Mapper;
//
//    @Override
//    public List<Project02> selectAll() {
//        return project02Mapper.selectAll();
//    }
//}


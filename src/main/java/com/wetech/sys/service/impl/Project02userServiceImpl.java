package com.wetech.sys.service.impl;

import com.wetech.sys.entity.Project02;
import com.wetech.sys.entity.Project02user;
import com.wetech.sys.mapper.Project02userMapper;
import com.wetech.sys.service.IProject02userService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class Project02userServiceImpl implements IProject02userService {
    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    private Project02userMapper project02userMapper;

    @Override
    public Map<String, Object> userlogin(Project02user project02user){
        Project02user result = project02userMapper.selectBy(project02user.getUsersname(),project02user.getUserspassword());

        if (result != null) {
            // 查询成功，生成token并将用户信息存入Redis
            // ...
            String key = "user" + UUID.randomUUID();
            //存入redis
            result.setUserspassword(null);
            redisTemplate.opsForValue().set(key,result,30, TimeUnit.MINUTES);

            //返回数据
            Map<String, Object> data = new HashMap<>();
            data.put("token",key);
            return data;
        }

        return null;
    }


    @Override
    public List<Project02user> userselectAll() {
        return project02userMapper.userselectAll();
    }
    @Override
    public void userlogout(String token) {
        redisTemplate.delete(token);
    }
}





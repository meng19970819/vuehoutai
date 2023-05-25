package com.wetech.sys.service;

import com.wetech.sys.entity.Project02;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


//public interface Project02Service {
//        boolean selectByUsernameAndPassword(Project02 project02);
//}
//public interface Project02Service {
//        List<Project02> selectAll();
//
//}

//        List<Project02> selectAll();

public interface Project02Service {
        Map<String, Object> login(Project02 project02);
        List<Project02> selectAll();
        void logout(String token);


}



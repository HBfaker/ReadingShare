package edu.bupt.controller;

import edu.bupt.serviceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 73681 on 2018/5/30.
 */
@RestController
public class TestController {
    @Autowired
    private UserServiceImp userServiceImp;

    @RequestMapping("/hello")
    public String test1() {
        return "hello";
    }
    @RequestMapping("/test")
    public String test() {
        return userServiceImp.selectByPrimaryKey(5).getTimeCreated().toString();
    }
    //测试
}

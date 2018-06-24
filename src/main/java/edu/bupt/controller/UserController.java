package edu.bupt.controller;

import edu.bupt.mapper.UserMapper;
import edu.bupt.pojo.User;
import edu.bupt.serviceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
用户
 */
@RestController
public class UserController {
    /*
    用户注册
    http://localhost/register?username=lisi&password=123
     */
    @Autowired
    UserServiceImp userServiceImp;
    @Autowired
    UserMapper userMapper;
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public Map register(@RequestParam(name="username",required=false) String username,
                        @RequestParam(name="password",required=false) String password) throws Exception {
        Map<String,Object> resp = new HashMap<String,Object>();

        try {
//        User user = userServiceImp.selectByPrimaryKey(1);
            if (username == null || password == null) {
                throw new Exception("注册时缺少用户名或密码");
            }
            User user = userMapper.selectByUsername(username);
            if (user != null) {
                throw new Exception("该用户名已注册");
            }
            user = new User();
            user.setUsername(username);
            user.setPassword(password);

            userServiceImp.insert(user);
            System.out.println(user);
            resp.put("status", 200);
            resp.put("msg", "ok");

        } catch(Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return resp;
    }
}

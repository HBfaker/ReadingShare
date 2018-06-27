package edu.bupt.controller;

import edu.bupt.mapper.UserMapper;
import edu.bupt.pojo.ApplyBook;
import edu.bupt.pojo.BookBorrowInfo;
import edu.bupt.pojo.User;
import edu.bupt.serviceImp.UserServiceImp;
import edu.bupt.util.TokenUtil;
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
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Map register(@RequestParam(name="username",required=false) String username,
                        @RequestParam(name="password",required=false) String password) throws Exception {
        Map<String,Object> resp = new HashMap<String,Object>();

        try {
//        User user = userServiceImp.selectByPrimaryKey(1);
            if (username == null || password == null) {
                throw new Exception("注册时缺少用户名或密码");
            }
            if (username.length() <6 || username.length() >25) {
                throw new Exception("用户名长度为6-25位");
            }
            if (password.length() <6 || password.length() >25) {
                throw new Exception("密码长度为6-25位");
            }
            User user = userMapper.selectByUsername(username);
            if (user != null) {
                throw new Exception("该用户名已注册");
            }
            user = new User();
            user.setUsername(username);
            user.setPassword(password);

            userServiceImp.insert(user);
//            System.out.println(user);
            resp.put("code", 200);
            resp.put("msg", "ok");

        } catch(Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return resp;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map login(@RequestParam(name="username",required=false) String username,
                        @RequestParam(name="password",required=false) String password) throws Exception {
        Map<String, Object> resp = new HashMap<String, Object>();
        User user = userMapper.selectByUsername(username);
        if(user == null) { throw new Exception("该用户名不存在"); }

        if(password==null || !user.getPassword().equals(password)) {
            throw new Exception("密码错误");
        }
        System.out.println("user:" + user);
        try {
            String token = TokenUtil.createToken(new Long(user.getId()));
            System.out.println("token:" + token);
            resp.put("code", 200);
            resp.put("msg", "ok");
            user.setPassword("加密");
            resp.put("user", user);
            resp.put("token", token);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    @RequestMapping(value = "applybook",method = RequestMethod.POST)
    public Map apply(ApplyBook info){
        Map<String,Object> resp = new HashMap();
        userServiceImp.ApplyBook(info);
        resp.put("status",200);
        resp.put("msg","OK");
        return resp;
    }


    @RequestMapping(value = "comment",method = RequestMethod.POST)
    public Map comment(BookBorrowInfo info){
        System.out.println(info.getEvaluate());
        Map<String,Object> resp = new HashMap();
        userServiceImp.userEvaluation(info);
        resp.put("status",200);
        resp.put("msg","OK");
        return resp;
    }
}

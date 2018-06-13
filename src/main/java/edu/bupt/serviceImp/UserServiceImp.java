package edu.bupt.serviceImp;

import edu.bupt.mapper.BaseMapper;
import edu.bupt.mapper.UserMapper;
import edu.bupt.pojo.User;
import edu.bupt.service.UserService;
import edu.bupt.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 73681 on 2018/5/30.
 */
@Service
public class UserServiceImp extends AbstractService<User,Integer> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseMapper getMapper() {
        return userMapper;
    }
}

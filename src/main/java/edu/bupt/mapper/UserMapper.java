package edu.bupt.mapper;

import edu.bupt.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by 73681 on 2018/5/30.
 */
@Repository
public interface UserMapper extends BaseMapper<User,Integer>{

    public User selectByUsername(String username);

    //根据条件查询
    public List<User> selectByCondition(Map condition);
}

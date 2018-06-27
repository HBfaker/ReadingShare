package edu.bupt.serviceImp;

import edu.bupt.mapper.*;
import edu.bupt.pojo.ApplyBook;
import edu.bupt.pojo.Book;
import edu.bupt.pojo.BookBorrowInfo;
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

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookBorrowInfoMapper bookBorrowInfoMapper;


    @Autowired
    private ApplyBookMapper applyBookMapper;

    @Override
    public BaseMapper getMapper() {
        return userMapper;
    }



    /*
    * 用户申请借书
    * */
    @Override
    public void ApplyBook(ApplyBook applyInfo) {
        applyBookMapper.insert(applyInfo);
    }

    /*
    * 用户同意申请,这个服务要用事务控制
    * */
    public void agreeApplication(BookBorrowInfo info){
        bookBorrowInfoMapper.insert(info);


    }


    /*
    * 用户提交评论，以及打分
    * */
    @Override
    public void userEvaluation(BookBorrowInfo info) {
        bookBorrowInfoMapper.updateByPrimaryKey(info);
    }
}

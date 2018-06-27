package edu.bupt.service;

import edu.bupt.pojo.ApplyBook;
import edu.bupt.pojo.BookBorrowInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 73681 on 2018/5/30.
 */
public interface UserService {
    /*
    * 申请借书
    * */
    public void ApplyBook(ApplyBook applyInfo);


    /*
    * 用户同意申请
    * */
    @Transactional
    public void agreeApplication(BookBorrowInfo info);


    public void userEvaluation(BookBorrowInfo info);
}

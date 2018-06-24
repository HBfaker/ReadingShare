package edu.bupt.pojo;

/**
 * Created by 73681 on 2018/6/21.
 */
public class BookBorrowInfo extends BaseModel{

    /*
    * 书籍id
    * */
    private int bookId;

    /**
     *出租方
     * */
    private int renterId;


    /**
     * 借阅方
     * */

    private int borrowerId;


    /*
    * 此次借阅过程评价
    * 1星，2星，3星，4星，5星
    * */
    private byte evaluate;


    /**
    *对书籍的评论
    * */
    private String comment;
}

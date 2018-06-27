package edu.bupt.pojo;

/**
 * Created by 73681 on 2018/6/21.
 */
public class BookBorrowInfo extends BaseModel{

    private long id;
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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getRenterId() {
        return renterId;
    }

    public void setRenterId(int renterId) {
        this.renterId = renterId;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public byte getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(byte evaluate) {
        this.evaluate = evaluate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

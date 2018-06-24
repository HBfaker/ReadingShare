package edu.bupt.pojo;

/**
 * Created by 73681 on 2018/6/18.
 */
public class Book extends BaseModel {

    private long id;


    /*
        * 这本书属于哪个用户
        * */
    private int userId;

    /**
     * 书籍的ISBN
     * */
    private String ISBN;

    /**
     * 书名
     * */
    private String bookName;


    /*
    * 作者名字
    * */
    private String author;


    /*
        * 出版社
        * */
    private String publisher;

    /**
    * 书籍照片路径
    * */
    private String bookImgPath;


    /**
     *借阅价格
     * */
    private int borrowPrice;

    /*
    * 出售价格
    * */
    private int rentPrice;

    /**
     *借书要求描述
     * */
    private String demandDecr;

    /*
    * 书籍的当前状态
    * 1：代表未借出
    * 2：以借出
    * */

    private byte status;

    /*
    * 书籍可操作的权限
    * 1:可借阅
    * 2：可出售
    * 3：可出售，可借阅
    * */

    private byte right;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImgPath() {
        return bookImgPath;
    }

    public void setBookImgPath(String bookImgPath) {
        this.bookImgPath = bookImgPath;
    }

    public int getBorrowPrice() {
        return borrowPrice;
    }

    public void setBorrowPrice(int borrowPrice) {
        this.borrowPrice = borrowPrice;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getDemandDecr() {
        return demandDecr;
    }

    public void setDemandDecr(String demandDecr) {
        this.demandDecr = demandDecr;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public byte getRight() {
        return right;
    }

    public void setRight(byte right) {
        this.right = right;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

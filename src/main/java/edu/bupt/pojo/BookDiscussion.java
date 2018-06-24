package edu.bupt.pojo;

/**
 * Created by 73681 on 2018/6/23.
 */
/*
* 书籍讨论实体类
* */
public class BookDiscussion extends BaseModel{

    private long id;

    /*
    * 评论用户的ID
    * */
    private int userId;

    /*
    * 书的isbn
    * */
    private String isbn;


    /*
    *评论
    * */
    private String content;



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

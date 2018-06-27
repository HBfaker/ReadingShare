package edu.bupt.pojo;

/**
 * Created by 73681 on 2018/6/26.
 * 借书申请信息
 */
public class ApplyBook extends BaseModel{

    private long id;

    private long bookId;

    private int renterId;

    private int proposerId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getRenterId() {
        return renterId;
    }

    public void setRenterId(int renterId) {
        this.renterId = renterId;
    }

    public int getProposerId() {
        return proposerId;
    }

    public void setProposerId(int proposerId) {
        this.proposerId = proposerId;
    }
}

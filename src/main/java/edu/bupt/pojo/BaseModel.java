package edu.bupt.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by 73681 on 2018/6/13.
 */
public class BaseModel<ID extends Serializable> implements Serializable {
    protected ID id;

    protected Timestamp timeCreated;

    protected Timestamp timeModified;


    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Timestamp getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(Timestamp timeModified) {
        this.timeModified = timeModified;
    }
}

package edu.bupt.pojo;

import java.io.Serializable;

/**
 * Created by 73681 on 2018/5/30.
 */
public class UserOAuth extends BaseModel implements Serializable{

    private int id;
    private String loginAccount;
    private String password;

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

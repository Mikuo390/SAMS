/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.pojo;

import java.io.Serializable;

/**
 * 账号类
 */
public class Account implements Serializable {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;

    @Override
    public boolean equals(Object obj) {
        //特例处理
        if(obj==null) return false;
        if(obj==this) return true;

        if(!(obj instanceof Account)) {//指向对象不行Account
            return false;
        }
        Account otherAccount = (Account)obj;

        return this.userName.equals(otherAccount.userName) && this.password.equals(otherAccount.password);
    }

    public Account() {
        super();
    }

    public Account(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


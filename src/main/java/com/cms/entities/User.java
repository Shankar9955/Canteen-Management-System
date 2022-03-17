package com.cms.entities;

public class User {

    private String prn;
    private String name;
    private String branch;
    private String mobile;
    private String email;
    private String password;
    private String vcode;

    public User(String prn, String name, String branch, String mobile, String email, String password,String vcode) {
        this.prn = prn;
        this.name = name;
        this.branch = branch;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.vcode=vcode;
        

    }

    public User(String prn, String password,String vcode) {
        this.prn = prn;
        this.password = password;
        this.vcode=vcode;
    }

    public User() {
    }

    public String getPrn() {
        return prn;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPrn(String prn) {
        this.prn = prn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    @Override
    public String toString() {
        return "User{" + "prn=" + prn + ", name=" + name + ", branch=" + branch + ", mobile=" + mobile + ", email=" + email + ", password=" + password + ", vcode=" + vcode + '}';
    }

 
    

}

package net.bitacademy.java72.step07.v09.member;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int     no;
  protected String  name;
  protected String  email;
  protected String  password;
  protected String  tel;
  protected Date    createDate;
  
  @Override
  public String toString() {
    return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", tel=" + tel
        + ", createDate=" + createDate + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  
  
}
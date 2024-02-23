package bitcamp.myapp.vo;


import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

  private static final long serialVersionUID = 100L;

  public int no;
  public String email;
  public String password;
  public String name;
  public Date createdDate;

  @Override
  public String toString() {
    return "Information{" +
        "no=" + no +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", name='" + name + '\'' +
        ", createdDate=" + createdDate +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}

package bitcamp.myapp.vo;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String name;
  private String email;
  private String phoneno;
  private String faxno;
  private String rank;
  private String position;
  private String password;
  private Date createdDate;
  private boolean currentlyemployed;
  private String birthday;
  private String postalcode;
  private String addressline1;
  private String addressline2;
  private String job;
  private String startdate;
  private String resignationday;


  @Override
  public String toString() {
    return "Employee{" +
        "no=" + no +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", phoneno='" + phoneno + '\'' +
        ", faxno='" + faxno + '\'' +
        ", rank='" + rank + '\'' +
        ", position='" + position + '\'' +
        ", password='" + password + '\'' +
        ", createdDate=" + createdDate +
        ", currentlyemployed=" + currentlyemployed +
        ", birthday='" + birthday + '\'' +
        ", postalcode='" + postalcode + '\'' +
        ", addressline1='" + addressline1 + '\'' +
        ", addressline2='" + addressline2 + '\'' +
        ", job='" + job + '\'' +
        ", startdate='" + startdate + '\'' +
        ", resignationday='" + resignationday + '\'' +
        '}';
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

  public String getPhoneno() {
    return phoneno;
  }

  public void setPhoneno(String phoneno) {
    this.phoneno = phoneno;
  }

  public String getFaxno() {
    return faxno;
  }

  public void setFaxno(String faxno) {
    this.faxno = faxno;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public boolean isCurrentlyemployed() {
    return currentlyemployed;
  }

  public void setCurrentlyemployed(boolean currentlyemployed) {
    this.currentlyemployed = currentlyemployed;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getPostalcode() {
    return postalcode;
  }

  public void setPostalcode(String postalcode) {
    this.postalcode = postalcode;
  }

  public String getAddressline1() {
    return addressline1;
  }

  public void setAddressline1(String addressline1) {
    this.addressline1 = addressline1;
  }

  public String getAddressline2() {
    return addressline2;
  }

  public void setAddressline2(String addressline2) {
    this.addressline2 = addressline2;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getStartdate() {
    return startdate;
  }

  public void setStartdate(String startdate) {
    this.startdate = startdate;
  }

  public String getResignationday() {
    return resignationday;
  }

  public void setResignationday(String resignationday) {
    this.resignationday = resignationday;
  }
}

package bitcamp.myapp.vo;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String title;
  private String content;
  private String writer;
  private Date createdDate;
  private String region;
  private String purpose;
  
  @Override
  public String toString() {
    return "Board{" +
        "no=" + no +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", writer='" + writer + '\'' +
        ", createdDate=" + createdDate +
        ", region='" + region + '\'' +
        ", purpose='" + purpose +
        '}';
  }
  public String getRegion() { return region; }
  public void setRegion (String region) { this.region = region; }

  public String getPurpose() { return purpose;}
  public void setPurpose (String purpose) { this.purpose = purpose; }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}

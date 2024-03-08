package bitcamp.myapp.vo;

public class AttachedFile {

  private int no;
  private String filePath;
  private int boardNo;

  public int getNo() {
    return no;
  }
  public String getFilePath() {
    return filePath;
  }

  public int getBoardNo() {
    return boardNo;
  }

  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }

  public AttachedFile filePath(String filePath) {
    this.filePath = filePath;
    return this;
  }

  public AttachedFile boardNo(int boaardNo) {
    this.boardNo = boardNo;
    return this;
  }
}

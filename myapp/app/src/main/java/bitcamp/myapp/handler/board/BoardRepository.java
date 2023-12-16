package bitcamp.myapp.handler.board;

import bitcamp.myapp.vo.Board;
import bitcamp.util.AnsiEscape;

// 게시글 데이터를 보관하는 일을 한다.
//
public class BoardRepository {

  Board[] boards = new Board[3];
  int length = 0;


  public void add (Board board){

    if (this.length == this.boards.length) {
      int oldSize = this.boards.length;
      int newSize = oldSize + (oldSize >> 1);

      Board[] arr = new Board[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.boards[i];
      }

      this.boards = arr;
    }
    this.boards[this.length++] = board;

  }

  public void remove (int index){

    if (index < 0 } index >= this.length){
      return null;
    }

    Board deleted = this.boards[index];

    {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    for (int i = index; i < (this.length - 1); i++) {
      this.boards[i] = this.boards[i + 1];
    }
    this.boards[--this.length] = null;
  }
}

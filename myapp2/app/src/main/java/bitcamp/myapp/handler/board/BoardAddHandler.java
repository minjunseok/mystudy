package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.Date;

public class BoardAddHandler extends AbstractMenuHandler {

  private BoardDao boardDao;

  public BoardAddHandler(BoardDao boardDao, Prompt prompt) {
    super(prompt);
    this.boardDao = boardDao;
  }

  @Override
  protected void action() {

    try {
      Board board = new Board();
      board.setTitle(this.prompt.input("제목을 입력해주세요"));
      board.setContent(this.prompt.input("내용을 입력해주세요"));
      board.setWriter(this.prompt.input("작성자명을 입력해주세요"));
      board.setRegion(this.prompt.input("활동 지역을 입력해주세요"));
      board.setPurpose(this.prompt.input("모집 목적을 입력해주세요"));

      boardDao.add(board);
    } catch (Exception e) {
      System.out.print("게시글 입력 오류!\n다시 시도해주세요!");
      e.printStackTrace();
    }
  }
}

package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.List;

public class BoardListHandler extends AbstractMenuHandler {

  private BoardDao boardDao;

  public BoardListHandler(BoardDao boardDao, Prompt prompt) {
    super(prompt);
    this.boardDao = boardDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%-4s\t%10s\t%10s\t%5s\n", "No", "Title", "Writer", "region",
        "purpose","Date");

    List<Board> list = boardDao.findAll();

    for (Board board : list) {
      System.out.printf("%-4d\t%-18s\t%-10s\t%-9s\t%-8s\t%6$tY-%6$tm-%6$td\n",
          board.getNo(),
          board.getTitle(),
          board.getWriter(),
          board.getRegion(),
          board.getPurpose(),
          board.getCreatedDate());
    }
  }
}

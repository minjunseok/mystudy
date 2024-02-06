package bitcamp.myapp.handler.notice;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.NoticeDao;
import bitcamp.myapp.vo.Notice;
import bitcamp.util.Prompt;
import java.util.List;

public class NoticeListHandler extends AbstractMenuHandler {

  private NoticeDao noticeDao;

  public NoticeListHandler(NoticeDao noticeDao, Prompt prompt) {
    super(prompt);
    this.noticeDao = noticeDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%s\n", "번호", "공지", "공지 작성일");

    List<Notice> list = noticeDao.findAll();

    for (Notice notice : list) {
      System.out.printf("%-4d\t%-20s\t%s\n",
          notice.getNo(),
          notice.getTitle(),
          notice.getCreatedDate());
    }
  }
}

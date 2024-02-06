package bitcamp.myapp.handler.notice;

import bitcamp.myapp.dao.NoticeDao;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.Prompt;

public class NoticeDeleteHandler extends AbstractMenuHandler {

  private NoticeDao noticeDao;

  public NoticeDeleteHandler(NoticeDao noticeDao, Prompt prompt) {
    super(prompt);
    this.noticeDao = noticeDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("공지 번호를 입력해주세요!");
      if (noticeDao.delete(no) == 0) {
        System.out.println("공지글 번호가 유효하지 않습니다!");
      } else {
        System.out.println("공지를 삭제했습니다.");
      }

    } catch (Exception e) {
      System.out.println("삭제 오류!");
      e.printStackTrace();
    }
  }
}

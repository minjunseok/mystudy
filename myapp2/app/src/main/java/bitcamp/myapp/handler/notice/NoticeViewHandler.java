package bitcamp.myapp.handler.notice;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.NoticeDao;
import bitcamp.myapp.vo.Notice;
import bitcamp.util.Prompt;

public class NoticeViewHandler extends AbstractMenuHandler {

  private NoticeDao noticeDao;

  public NoticeViewHandler(NoticeDao noticeDao, Prompt prompt) {
    super(prompt);
    this.noticeDao = noticeDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("공지글 번호? ");
      Notice notice = noticeDao.findBy(no);
      if (notice == null) {
        System.out.println("공지글 번호가 유효하지 않습니다!");
        return;
      }

      System.out.printf("번호: %s\n", notice.getNo());
      System.out.printf("공지제목: %s\n", notice.getTitle());
      System.out.printf("내용: %s\n", notice.getContent());
      System.out.printf("공지 작성일: %s\n", notice.getCreatedDate());

    } catch (Exception e) {
      System.out.println("조회 오류!");
      e.printStackTrace();
    }
  }

}

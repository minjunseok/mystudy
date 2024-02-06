package bitcamp.myapp.handler.notice;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.NoticeDao;
import bitcamp.myapp.vo.Notice;
import bitcamp.util.Prompt;
import java.util.Date;

public class NoticeAddHandler extends AbstractMenuHandler {

  private NoticeDao noticeDao;


  public NoticeAddHandler(
      NoticeDao noticeDao, Prompt prompt) {
    super(prompt);
    this.noticeDao = noticeDao;
  }

  @Override
  protected void action() {
    try {
      Notice notice = new Notice();
      notice.setTitle(this.prompt.input("공지 제목을 입력해주세요 "));
      notice.setContent(this.prompt.input("내용을 입력해주세요 "));
      notice.setCreatedDate(new Date());


      noticeDao.add(notice);

    } catch (Exception e) {
      System.out.println("공지글 입력 중 오류 발생!");
      System.out.println("다시 시도하시기 바랍니다.");
      e.printStackTrace();
    }
  }
}

package bitcamp.myapp.handler.notice;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.NoticeDao;
import bitcamp.myapp.vo.Notice;
import bitcamp.util.Prompt;

public class NoticeModifyHandler extends AbstractMenuHandler {

  private NoticeDao noticeDao;

  public NoticeModifyHandler(NoticeDao noticeDao, Prompt prompt) {
    super(prompt);
    this.noticeDao = noticeDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("공지글 번호? ");

      Notice old = noticeDao.findBy(no);
      if (old == null) {
        System.out.println("공지글 번호가 유효하지 않습니다!");
        return;
      }

      Notice notice = new Notice();
      notice.setNo(old.getNo());
      notice.setTitle(this.prompt.input("공지글 제목(%s)? ", old.getTitle()));
      notice.setContent(this.prompt.input("내용(%s)? ", old.getContent()));


      noticeDao.update(notice);
      System.out.println("공지 내용을 변경했습니다.");

    } catch (NumberFormatException e) {
      System.out.println("숫자를 입력하세요!");

    } catch (IllegalArgumentException e) {
      System.out.println("공지글 변경 오류!");
      System.out.println("다시 시도 하세요.");

    } catch (Exception e) {
      System.out.println("실행 오류!");
      e.printStackTrace();
    }

  }
}

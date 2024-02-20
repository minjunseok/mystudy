package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.EmployeeDao;
import bitcamp.util.Prompt;

public class MemberDeleteHandler extends AbstractMenuHandler {

  private EmployeeDao employeeDao;

  public MemberDeleteHandler(EmployeeDao employeeDao, Prompt prompt) {
    super(prompt);
    this.employeeDao = employeeDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (employeeDao.delete(no) == -1) {
      System.out.println("회원 번호가 유효하지 않습니다!");
    } else {
      System.out.println("회원을 삭제했습니다.");
    }
  }
}

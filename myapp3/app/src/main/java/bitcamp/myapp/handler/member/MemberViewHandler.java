package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.EmployeeDao;
import bitcamp.myapp.vo.Employee;
import bitcamp.util.Prompt;

public class MemberViewHandler extends AbstractMenuHandler {

  private EmployeeDao employeeDao;

  public MemberViewHandler(EmployeeDao employeeDao, Prompt prompt) {
    super(prompt);
    this.employeeDao = employeeDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Employee employee = employeeDao.findBy(no);
    if (employee == null) {
      System.out.println("회원 번호가 유효하지 않습니다!");
      return;
    }

    System.out.printf("번호: %d\n", employee.getNo());
    System.out.printf("이메일: %s\n", employee.getEmail());
    System.out.printf("이름: %s\n", employee.getName());
    System.out.printf("가입일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", employee.getCreatedDate());
  }
}

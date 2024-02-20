package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.EmployeeDao;
import bitcamp.myapp.vo.Employee;
import bitcamp.util.Prompt;

public class MemberModifyHandler extends AbstractMenuHandler {

  private EmployeeDao employeeDao;

  public MemberModifyHandler(EmployeeDao employeeDao, Prompt prompt) {
    super(prompt);
    this.employeeDao = employeeDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Employee old = employeeDao.findBy(no);
    if (old == null) {
      System.out.println("회원 번호가 유효하지 않습니다!");
      return;
    }

    Employee employee = new Employee();
    employee.setNo(old.getNo());
    employee.setEmail(this.prompt.input("이메일(%s)? ", old.getEmail()));
    employee.setName(this.prompt.input("이름(%s)? ", old.getName()));
    employee.setPassword(this.prompt.input("새 암호? "));
    employee.setCreatedDate(old.getCreatedDate());

    employeeDao.update(employee);
    System.out.println("회원을 변경했습니다.");
  }
}

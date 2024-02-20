package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.EmployeeDao;
import bitcamp.myapp.vo.Employee;
import bitcamp.util.Prompt;
import java.util.List;

public class MemberListHandler extends AbstractMenuHandler {

  private EmployeeDao employeeDao;

  public MemberListHandler(EmployeeDao employeeDao, Prompt prompt) {
    super(prompt);
    this.employeeDao = employeeDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-10s\t%30s\t%s\n", "번호", "이름", "이메일", "가입일");

    List<Employee> list = employeeDao.findAll();

    for (Employee employee : list) {
      System.out.printf("%-4d\t%-10s\t%30s\t%4$tY-%4$tm-%4$td\n",
          employee.getNo(),
          employee.getName(),
          employee.getEmail(),
          employee.getCreatedDate());
    }
  }
}

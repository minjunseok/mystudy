package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.EmployeeDao;
import bitcamp.myapp.vo.Employee;
import bitcamp.util.Prompt;
import java.util.Date;

public class MemberAddHandler extends AbstractMenuHandler {

  private EmployeeDao employeeDao;

  public MemberAddHandler(EmployeeDao employeeDao, Prompt prompt) {
    super(prompt);
    this.employeeDao = employeeDao;
  }

  @Override
  protected void action() {
    Employee employee = new Employee();
    employee.setEmail(this.prompt.input("이메일? "));
    employee.setName(this.prompt.input("이름? "));
    employee.setPassword(this.prompt.input("암호? "));
    employee.setCreatedDate(new Date());

    employeeDao.add(employee);
  }
}

package bitcamp.myapp.servlet.employee;

import bitcamp.myapp.dao.EmployeeDao;
import bitcamp.myapp.vo.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeAddServlet extends HttpServlet {

  private EmployeeDao employeeDao;

  @Override
  public void init() throws ServletException {
    this.employeeDao = (EmployeeDao) this.getServletContext().getAttribute("employeeDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;char=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lan='en'>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>건강관리 시스템</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>사원</h1>");

//
//    private int no;                         사원번호
//    private String name;                    이름
//    private String email;                   이메일
//    private String phoneno;                 전화번호
//    private String faxno;                   팩스번호
//    private String rank;                    직급
//    private String position;                직책
//    private String password;                비밀번호
//    private String birthday;                생일
//    private String postalcode;              우편번호
//    private String addressline1;            주소1
//    private String addressline2;            주소2
//    private String job;                     직종
//    private String startdate;               입사일
//    private String resignationday;          퇴사일

    try {
      Employee employee = new Employee();
      employee.setName(request.getParameter("name"));
      employee.setPassword(request.getParameter("password"));
      employee.setEmail(request.getParameter("email"));
      employee.setPhoneno(request.getParameter("phonenno"));
      employee.setFaxno(request.getParameter("faxno"));
      employee.setRank(request.getParameter("rank"));
      employee.setPosition(request.getParameter("position"));
      employee.setBirthday(request.getParameter("birthday"));
      employee.setPostalcode(request.getParameter("postalcode"));
      employee.setAddressline1(request.getParameter("addressline1"));
      employee.setAddressline2(request.getParameter("addressline2"));
      employee.setJob(request.getParameter("job"));
      employee.setStartdate(request.getParameter("startdate"));
      employee.setResignationday(request.getParameter("resignationday"));

      employeeDao.add(employee);
      out.println("<p>사원등록이 완료되었습니다.</p>");

    } catch (Exception e) {
      out.println("<p>사원등록 오류!</p>");
      out.println("pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("<html");
  }
}

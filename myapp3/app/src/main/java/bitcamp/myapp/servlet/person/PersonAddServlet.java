package bitcamp.myapp.servlet.person;

import bitcamp.myapp.dao.PersonDao;
import bitcamp.myapp.vo.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("person/add")
public class PersonAddServlet extends HttpServlet {


  private PersonDao personDao;

  @Override
  public void init() {
    this.personDao = (PersonDao) this.getServletContext().getAttribute("personDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

  out.println("<!DOCTYPE html>");
      out.println("<html lang='en'>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
        out.println("<title>건강 관리 시스템입니다</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>가입하기<h1>");

    try {
      Person person = new Person();
      person.setName(request.getParameter("name"));
      person.setEmail(request.getParameter("email"));
      person.setPassword(request.getParameter("password"));

      personDao.add(person);
      out.println("<p>가입이 정상적으로 완료되었습니다</p>");

    } catch(Exception e) {
     out.println("<p>가입 오류 관리자에게 문의하세요.</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println(" </pre>");
    }
    out.println("  </body>");
    out.println(" </html>");
  }
}

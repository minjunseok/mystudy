package bitcamp.myapp.servlet.auth;

import bitcamp.myapp.dao.PersonDao;
import bitcamp.myapp.vo.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
  
  PersonDao personDao;

  @Override
  public void init() {
    this.personDao = (PersonDao)this.getServletContext().getAttribute("personDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>건강 관리 시스템입니다</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<환영합니다>");
    out.println("h1>로그인</h1>");

    try {
      Person person = personDao.findByEmailAndPassword(email, password);
      if (person != null) {
        request.getSession().setAttribute("loginUser", person);
      out.printf("<p>%s 님 환영합니다.</p>\n", person.getName());
    } else {
      out.println("<p>이메일 또는 암호가 틀렸습니다.</p>");
    }
  } catch (Exception e) {
      out.println("<p>로그인 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}

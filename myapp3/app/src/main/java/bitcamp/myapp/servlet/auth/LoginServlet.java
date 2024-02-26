package bitcamp.myapp.servlet.auth;

import bitcamp.myapp.dao.PersonDao;
import bitcamp.myapp.vo.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String email = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("email")) {
          email = cookie.getValue();
          break;
        }
      }
    }
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>건강 관리 시스템입니다</title>");
    out.println("</head>");
    out.println("<body>");

    request.getRequestDispatcher("/heder").include(request, response);

    out.println("h1>로그인</h1>");

    out.println("<form action='/auth/login' method='post'>");
    out.println("<div>");
    out.printf("    이메일: <input name='email' type='text' value='%s'>\n", email);
    out.println("</div>");
    out.println("<div>");
    out.println("     암호: <input name='password' type='password'>");
    out.println("</div>");
    out.println("<button>로그인</button>");
    out.println("<input type='checkbox' name='saveEmail'> 이메일 저장");
    out.println("</form");

    request.getRequestDispatcher("/footer").include(request, response);

    out.println("</body>");
    out.println("</html>");
  }



  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    String saveEmail = request.getParameter("saveEmail");
    if (saveEmail != null) {
      Cookie cookie = new Cookie("email", email);
      cookie.setMaxAge(60 * 60 * 24 * 7);
      response.addCookie(cookie);
    } else {
      Cookie cookie = new Cookie("email", "");
      cookie.setMaxAge(0);
      response.addCookie(cookie);
    }

    Person person = personDao.findByEmailAndPassword(email, password);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>건강 관리 시스템입니다</title>");
    out.println("</head>");
    out.println("<body>");

    request.getRequestDispatcher("/header").include(request, response);

    out.println("h1>로그인</h1>");



      if (person != null) {
        request.getSession().setAttribute("loginUser", person);
      out.printf("<p>%s 님 환영합니다.</p>\n", person.getName());
      response.setHeader("Refresh", "1;url=/index.html");

    } else {
      out.println("<p>이메일 또는 암호가 틀렸습니다.</p>");
      response.setHeader("Refresh", "1;url=/auth/login");
    }
      request.getRequestDispatcher("/footer").include(request, response);

      out.println("</body>");
      out.println("<html");

  } catch (Exception e) {
    request.setAttribute("message", "로그인 오류!");
    request.setAttribute("exception", e);
    request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}



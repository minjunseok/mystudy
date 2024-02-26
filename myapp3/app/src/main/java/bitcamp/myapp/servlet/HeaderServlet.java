package bitcamp.myapp.servlet;

import bitcamp.myapp.vo.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    // 현재 주요 기능들.
//    직원등록
//    건강정보
//    건강관리자정보
//    질문게시판
//    공지게시판
//    건강검진날짜조회
//    관리자메뉴-직원정보 CRUD


    out.println("<header");
    out.println(
        " <img src='https://cdn-icons-png.flaticon.com/512/5455/5455384.png'>");
    out.println(" <a href='/person/add'>직원등록</a>");


    Person loginUser = (Person) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      out.println("  <a href='auth/login'>로그인</a>");
    } else {
      out.printf(" <span>%s</span>\n", loginUser.getName());
      out.println("  <a href='/auth/logout'>로그아웃</a>");
    }

    out.println("  <a href='about.html'>소개</a>");

    out.println("</header>");

  }
}


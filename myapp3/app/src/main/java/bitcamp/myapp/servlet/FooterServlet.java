package bitcamp.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/footer")
public class FooterServlet extends HttpServlet {


  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();


    out.println(
        "<footer style='background-color:gray; color:white; padding:10px; text-align:center;'>");
    out.println("  <address> -건강관리자 주소 출력 라인- </address>");
    out.println("  <p>&copy; 유선문의 010-0000-0000 상담시간 : 공휴일 제외 09:00 ~ 15:30</p?>");
    out.println("</footer>");
  }
}

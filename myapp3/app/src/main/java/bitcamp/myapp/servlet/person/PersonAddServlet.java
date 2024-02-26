package bitcamp.myapp.servlet.person;

import bitcamp.myapp.dao.PersonDao;
import bitcamp.myapp.vo.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/person/add")
public class PersonAddServlet extends HttpServlet {

  private String uploadDir;
  private PersonDao personDao;

  @Override
  public void init() {
    this.personDao = (PersonDao) this.getServletContext().getAttribute("personDao");
    uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
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

    request.getRequestDispatcher("/header").include(request, response);

    out.println("<h1 > 건강관리 시스템 </h1 >");

    out.println("<h2 > 직원등록 < h2 >");

    out.println("<form action = '/person/add' method = 'post' enctype='multipart/form-data'>");
    out.println("<div>");
    out.println("이메일 : <input name = 'email' type = 'text'>");
    out.println("</div>");
    out.println("<div>");
    out.println("암호 : <input name = 'password' type = 'password'>");
    out.println("</div>");
    out.println("<div>");
    out.println("사진 : <input name = 'photo' type = 'file'>");
    out.println("</div>");
    out.println("<div>");
    out.println("<button > 등록 </button>");
    out.println("</div>");
    out.println("</form>");

    request.getRequestDispatcher("/footer").include(request, response);

    out.println("</body >");
        out.println("</html >");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      request.setCharacterEncoding("UTF-8");

      Person person = new Person();
      person.setEmail(request.getParameter("email"));
      person.setName(request.getParameter("name"));
      person.setPassword(request.getParameter("password"));

      Part photoPart = request.getPart("photo");
      if (photoPart.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        person.setPhoto(filename);
        photoPart.write(this.uploadDir + "/" + filename);
      }

      personDao.add(person);
      response.sendRedirect("list");

  } catch (Exception e) {
    request.setAttribute("message", "등록 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
}
}
}

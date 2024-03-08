package com.eomcs.web.ex12;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener01 implements ServletContextListener {


  //실행될 때
  @Override
  public void contextInitialized(ServletContextEvent sce) {

    ServletContext sc = sce.getServletContext();

    Servlet03 s = new Servlet03();
    Dynamic 서블릿설정정보 = sc.addServlet("ex12.Servlet03",s);   //web.xml 에 배치하는 <servlet>...<</servlet>와 같다
    서블릿설정정보.addMapping("/ex12/s03"); // <servlet-mapping>...</servlet-mapping>과 같다
  //애노테이션 html 은 선언적으로 설정하는방법 위 방법은 동적으로 서블릿을 배치하는 방법.

  }
}

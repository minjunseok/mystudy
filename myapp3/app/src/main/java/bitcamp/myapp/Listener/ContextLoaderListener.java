package bitcamp.myapp.Listener;

import bitcamp.myapp.dao.EmployeeDao;
import bitcamp.util.DBConnectionPool;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
  //웹 애플리케이션이 사용할 자원을 준비시키고 해제시키는 역할


  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("웹애플리케이션 자원 준비!");

    //DB 커넥션 , DAO , 트랜잭션 관리자 생성

    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");

    EmployeeDao employeeDao = new EmployeeDaoImpl(connectionPool);

  }
}

// JDBC 프로그래밍 - DBMS에 연결하기
package com.eomcs.jdbc.ex1;

import java.sql.DriverManager;

public class Exam221 {

  public static void main(String[] args) throws Exception {

    // try-with-resources 문법을 사용하면
    // try 블록을 벗어날 때 close()가 자동 호출된다.
    int count = 0;
    while (true) {
      try (java.sql.Connection con =
          DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", // jdbcURL
              "study", // username
              "Bitcamp!@#123" // password
          );) {

        System.out.printf("DBMS와 연결됨!", ++count);

      }
      System.out.println("DBMS와 연결 해제됨!");
    }
  }
}



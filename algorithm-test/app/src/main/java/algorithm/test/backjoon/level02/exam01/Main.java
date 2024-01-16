package algorithm.test.backjoon.level02.exam01;

import java.util.Scanner; // 자바 기본 도구 스캐너를 사용하겠다

public class Main { // 클래스 선언
  public static void main(String[] args) { // 메서드 선언
    Scanner sc = new Scanner(System.in); // sc라는 레퍼런스의 스캐너 인스턴스 생성
    long a = sc.nextLong(); // 사용자가 입력한 long값을 스캐너 인스턴스 레퍼런스에 담아 long 메모리 a에 저장
    long b = sc.nextLong(); // 사용자가 입력한 long값을 스캐너 인스턴스 레퍼런스에 담아 long 메모리 b에 저장

    sc.close(); // 입력도구는 사용후 닫아줘야한다.

    if (a > b) { // 만약 a 가 b보다 크면?
      System.out.print(">"); // >를 출력하겠다.
    } else if (a < b) { // 아니라면 만약에 a 가 b보다 작으면?
      System.out.print("<"); // <를 출력하겠다.
    } else { // 위 두가지 경우가 모두 아니라면
      System.out.print("=="); // ==를 출력하겠다.

    }
  }

}

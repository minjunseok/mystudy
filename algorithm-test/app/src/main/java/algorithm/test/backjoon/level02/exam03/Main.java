package algorithm.test.backjoon.level02.exam03;

import java.util.Scanner; // 자바 기본도구 스캐너 사용


public class Main { // 클래스 선언
  public static void main(String[] args) { // 메서드 선언
    Scanner sc = new Scanner(System.in); // 스캐너 인스턴스 생성
    int a = sc.nextInt(); // 변수 a 스캐너 인스턴스로 입력한 값을 저장

    if (a % 4 == 0) { // a는 4의 배수여야함 기본조건
      if (a % 400 == 0 || a % 100 != 0) { // a가 400의 배수이거나 또는 100의 배수가 아니면?
        System.out.print("1"); // 1을 출력 = 입력값이 윤년이다.
      } else {
        System.out.print("0"); // 아니면 0을 출력 = 입력값이 평년이다.
      }
    } else {
      System.out.print("0"); // a가 4의 배수가 아니면 0을 출력 = 입력값이 평년이다.
    }
  }

}

package algorithm.test.backjoon.level3.exam04;

import java.util.Scanner;

// 영수증 내역 확인하기

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int temp = 0; // 연산결과를 저장할 temp변수 선언
    int X = sc.nextInt(); // 영수증에 찍힌 물건의 총 금액을 다룰 입력 int 변수
    int N = sc.nextInt(); // 물건 분류를 다룰 입력 int 변수


    for (int i = 0; i < N; i++) { // 반복문에서 사용할 i 변수 초기화 i가 분류의 수치가 되면 반복문 종료
      int a = sc.nextInt(); // 물건 가격을 다룰 입력 int 변수
      int b = sc.nextInt(); // 물건 개수를 다룰 입력 int 변수
      temp += a * b; // 물건 가격과 개수를 곱하여 temp에 저장한다
    }
    if (temp == X) { // 반복문을 통한 계산 가격이 일치한다면?
      System.out.println("Yes"); // Yes를 출력
    } else { // 일치하지 않는다면
      System.out.print("No"); // No를 출력
    }
  }
}



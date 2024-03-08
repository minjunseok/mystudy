package algorithm.test.backjoon.level3.exam07;

import java.util.ArrayList;
import java.util.Scanner;
// import java.util.*; 와일드 카드로 대체해서 간결하게 만들 수 있다.



public class Main {
  public static void main(String[] args) {
    ArrayList<Object> temps = new ArrayList<>(); // 자바 도구 클래스 두개의 대한 객체 생성
    // int 타입을 저장할 ArrayList 인스턴스 변수 temps 생성
    Scanner sc = new Scanner(System.in); //
    int T = sc.nextInt(); // 연산을 몇번 수행하고 출력할지 정할 횟수를 정할 입력 변수 T

    for (int i = 0; i < T; i++) { // 입력 횟수만큼 연산을 수행할 수 2개를 입력 받을게
      int a = sc.nextInt(); // 입력 변수 a
      int b = sc.nextInt(); // 입력 변수 b
      temps.add(a + b); // 두 수를 더하고 ArrayList 인스턴스 변수를 저장한다.

    }
    for (int i = 0; i < T; i++) { // 입력 횟수만큼 연산을 출력한다.
      System.out.printf("Case #%d: %d\n", i + 1, temps.get(i));
      // Case #사례번호: 연산결과 형식으로 연산결과를 저장한 i번째 결과를 차례대로 출력한다.
      // 대신 i가 아닌 i + 1 를 입력해 시작이 0번째가 되지않도록 해준다.

    }

  }
}

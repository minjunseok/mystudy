package algorithm.test.backjoon.level3.exam08;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // 스캐너 객체 생성
    ArrayList<Integer> temps = new ArrayList<>();

    // 연산에 사용된 수 2개와 연산결과 저장을 위한 ArrayList 객체 생성
    // ArrayList를 사용하면 보다 효율적으로 객체배열을 다룰 수 있다.
    // int 타입을 저장 할 것이기에 제네릭 타입은 Integer로 선언한다
    ArrayList<Integer> tempsa = new ArrayList<>();
    ArrayList<Integer> tempsb = new ArrayList<>();


    int T = sc.nextInt(); // 연산 횟수 입력 변수

    for (int i = 0; i < T; i++) { // 입력된 횟수만큼 반복한다.
      int a = sc.nextInt(); // 연산에 사용될 변수 a 입력
      int b = sc.nextInt(); //// 연산에 사용될 변수 b 입력
      tempsa.add(a); // 연산에 사용된 변수 a를 ArrayList tempsa에 저장
      tempsb.add(b); // 연산에 사용된 변수 b를 ArrayList tempsb에 저장
      temps.add(a + b); // 연산 결과를 ArrayList temps에 저장
    }
    for (int i = 0; i < T; i++) { // 저장한 ArrayList 내 데이터들을 횟수만큼 출력시켜준다.
      System.out.printf("Case #%d : %d + %d = %d\n", i + 1, tempsa.get(i), tempsb.get(i),
          temps.get(i));
    }


  }
}

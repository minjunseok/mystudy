package algorithm.test.backjoon.level3.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt(); // 입력변수 a 선언
    int b = a / 4; // long은 4바이트이므로 입력한 수 a를 4로 나눈 몫을 저장할 변수 b 선언



    for (int i = 0; i < b; i++) { // b보다 작을 때까지 반복문을 돌린다.
      System.out.print("long" + " "); // long 과 공백 출력
    }
    System.out.print("int"); // 맨 뒤에 int 출력
  }

}

package algorithm.test.backjoon.level3.exam02;

import java.util.Scanner;



// 두 정수와 연산 횟수를 입력받아 반복문을 통해 연산하기
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


    int t = sc.nextInt();



    for (int i = 0; i < t; i++) {
      int b = sc.nextInt();

      int c = sc.nextInt();

      System.out.println(b + c);
    }
  }
}

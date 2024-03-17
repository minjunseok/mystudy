package algorithm.test.backjoon.level3.exam09;

import java.util.Scanner;



// 횟수를 입력받고 횟수만큼 별 출력하기

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();

    for (int i = 1; i <= a; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}



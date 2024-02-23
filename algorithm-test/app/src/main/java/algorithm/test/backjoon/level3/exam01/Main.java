package algorithm.test.backjoon.level3.exam01;

import java.util.Scanner;


// 입력한 수에 따라 9단까지의 구구단 출력하기
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    for (int i = 1; i < 10; i++) {
      System.out.printf("%d * %d = %d\n", a, i, a * i);
    }
  }
}



package algorithm.test.backjoon.level02.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int h = sc.nextInt(); // 시간
    int m = sc.nextInt(); // 분


    if (m < 60 && m >= 45) {
      m = m - 45;
    } else if (m < 45 && h > 0) {
      m = m + 15;
      h = h - 1;
    } else {
      m = m + 15;
      h = h + 23;
    }
    System.out.print(h + " " + m);
  }

}

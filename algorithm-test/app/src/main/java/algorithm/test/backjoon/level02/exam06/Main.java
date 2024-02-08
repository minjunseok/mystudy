package algorithm.test.backjoon.level02.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int h = sc.nextInt();
    int m = sc.nextInt();
    int c = sc.nextInt();


    if (m + c > 60) {
      h += (m + c) / 60;
      m = (m + c) % 60;
      if (h >= 24)
        h = h - 24;
    } else if (m + c < 60 && m + c > 0) {
      m += c;
    }
    System.out.print(h + " " + m);
  }
}



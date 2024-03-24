package algorithm.test.backjoon.level3.exam10;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count = sc.nextInt();

    for (int i = 0; i < count; i++) {
      for (int l = count - 1; l > i; l--) {
        System.out.printf(" ");
      }
      for (int j = 0; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

  }
}



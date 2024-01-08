package algorithm.test.backjoon.level01.exam10;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    int d1 = (a + b) % c;
    int d2 = ((a % c) + (b % c)) % c;
    int d3 = (a * b) % c;
    int d4 = ((a % c) * (b % c)) % c;

    System.out.println(d1);
    System.out.println(d2);
    System.out.println(d3);
    System.out.println(d4);



  }

}

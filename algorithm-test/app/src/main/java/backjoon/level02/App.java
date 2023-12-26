package backjoon.level02;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner keyIn = new Scanner(System.in);
    double a = keyIn.nextInt();
    double b = keyIn.nextInt();
    keyIn.close();

    System.out.println(a / b);

  }

}

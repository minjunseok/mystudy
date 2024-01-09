package algorithm.test.backjoon.level01.exam11;

import java.util.Scanner;


public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int n3 = b / 100; // 100의자리 추출
    int n1 = b % 10; // 1의자리 추출
    int n2 = (b - (n3 * 100) - n1) / 10; // 10의자리 추출
    int c1 = a * n1; // a와 b의 1의자리 곱하기
    int c2 = a * n2; // a와 b의 10의자리 곱하기
    int c3 = a * n3; // a와 b의 100의자리 곱하기
    int c4 = (a * n1) + ((a * n2) * 10) + ((a * n3) * 100); // a 와 b의 각 자리수 곱한 것 모두 더하기


    System.out.print(c1 + "\n"); // a와 b의 1의자리 곱하기 결과 출력
    System.out.print(c2 + "\n"); // a와 b의 10의자리 곱하기 결과 출력
    System.out.print(c3 + "\n"); // a와 b의 100의자리 곱하기 결과 출력
    System.out.print(c4 + "\n"); // a 와 b의 각 자리수 곱한 것 모두 더하기 결과 출력

  }
}


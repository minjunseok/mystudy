package algorithm.test.backjoon.level02.exam11;

import java.util.Scanner;


public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);


    int temp = 0; // 연산결과를 저장할 변수 temp 선언


    while (true) { // 반복문을 돌린다.
      int a = sc.nextInt(); // 입력 변수 a 선언

      if (0 < a && a <= 10000) { // 입력한 값 a가 0보다 크고 10000 보다는 작거나 같을 때
        for (int i = 1; i <= a; i++) { // i는 1로 초기화해서 a보다 같거나 작을 때까지 증가시키는 반복문을 돌린다
          temp += i; // 조건에 따라 증가하는 i의 값을 temp 변수에 더하여 저장
        }
        System.out.print(temp); // temp 출력
        break; // 반복문을 끝낸다
      } // 조건에 맞지 않은 수를 입력시 반복문으로 진입하지 않고 입력을 반복시킨다.
    }
  }
}

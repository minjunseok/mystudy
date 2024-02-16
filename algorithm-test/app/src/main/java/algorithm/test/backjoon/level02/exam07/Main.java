
package algorithm.test.backjoon.level02.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 주사위 3개 값을 저장할 사용자 입력 변수 a,b,c a,b,c의 연산값을 저장할 변수 t 선언
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int t = 0;


    if (0 < a && a < 7 && 0 < b && b < 7 && 0 < c && c < 7) { // 만약 a,b,c는 1~6 눈을 가진 주사위라면?
      if (a == b && b == c) { // 위 조건 충족시 만약 세 주사위 값이 모두 같다면?
        t += a * 1000 + 10000; // 어차피 세 주사위값은 같으므로 같은 주사위 중 하나에 대해서만 연산 실행후 t에 저장한다.
        System.out.print(t); // t값 = 받을 상금 출력
      } else if (a != b && b != c && a != c) { // 그렇지 않고 만약 세 주사위값이 모두 다르다면
        if (a < c && b < c) // 만약 c가 제일 크다면?
          t += c * 100; // 주사위 c에 대해서만 연산 실행 후 결과 t변수에 저장
        if (b < a && c < a) // 만약 a가 제일 크다면?
          t += a * 100; // 주사위 a에 대해서만 연산 실행 후 결과 t변수에 저장
        if (a < b && c < b) // 만약 b가 제일 크다면?
          t += b * 100; // 주사위 c에 대해서만 연산 실행 후 결과 t변수에 저장
        System.out.print(t); // t값 = 받을 상금 출력
      } else if (a == b || b == c || c == a) { // 만약 세 주사위 중 두 주사위의 수만 같다면?
        if (a == b) { // 주사위 a와 b가 같다면?
          t += a * 100 + 1000; // a와 b주사위는 같은 값을 가지므로 a 주사위에 대해서만 연산 실행 후 결과 t변수에 저장
        }
        if (b == c) { // 주사위 b와 c가 같다면?
          t += b * 100 + 1000; // b와 c주사위는 같은 값을 가지므로 b 주사위에 대해서만 연산 실행 후 결과 t변수에 저장
        }
        if (c == a) { // 주사위 a와 c가 같다면?
          t += c * 100 + 1000; // a와 c주사위는 같은 값을 가지므로 c 주사위에 대해서만 연산 실행 후 결과 t변수에 저장
        }
        System.out.print(t); // t값 = 받을 상금 출력
      }
    }
  }
}



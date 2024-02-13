package algorithm.test.backjoon.level02.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int h = sc.nextInt(); // 스캐너로 시간 입력받는 변수 h
    int m = sc.nextInt(); // 스캐너로 분 입력받는 변수 m
    int c = sc.nextInt(); // 스캐너로 타이머 입력받는 변수 c


    if (m + c >= 60) { // 만약 타이머와 분을 더한 값이 60보다 크면?
      h += (m + c) / 60; // 타이머 + 분을 더한 값을 60으로 나누고 그 몫을 h 변수에 더하고 저장
      m = (m + c) % 60; // 타이머 + 분을 더한 값을 60으로 나누고 그 나머지를 m 변수에 더하고 저장
      if (h >= 24) // 위 조건과 동시에 돌린다. 만약 시간이 24시거나 그 이상이면?
        h = h - 24; // 시간에 24를 뺀 값을 h 변수에 저장한다.
    } else if (m + c < 60 && m + c > 0) { // 위 조건이 아니고 분과 타이머를 더한 값이 0보단 크고 60보다 작으면?
      m += c; // 타이머를 변수 m에 더하고 저장한다.
    }
    System.out.print(h + " " + m); // 위 조건문 돌린 변수 h,m 출력.
  }
}



package algorithm.test.backjoon.level3.exam06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 항상 써오던 out.print가 아닌 io 클래스와 util 클래스의 도구를 활용해서 출력하겠다.
    try { // io클래스는 io Exception이 동반될 수 있으므로 throws를 던져야

      int op = Integer.parseInt(br.readLine()); // 횟수를 입력받을 op 변수 선언

      for (int i = 0; i < op; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        bw.write(a + b + "\n");
      }
      bw.flush();
      bw.close();
    } catch (Exception e) {
    }
  }
}



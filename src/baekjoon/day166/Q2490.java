package baekjoon.day166;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2490 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    String[] resultArr = {"E", "A", "B", "C", "D"}; // 배(0)의 개수에 따라 결과가 달라진다.
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      // 도는 A, 개는 B, 걸은 C, 윷은 D, 모는 E
      int belly = 0;
      for (int j = 0; j < 4; j++) {
        if (Integer.parseInt(st.nextToken()) == 0) {
          belly++;
        }
      }
      sb.append(resultArr[belly]).append("\n");
    }
    System.out.println(sb);
  }
}

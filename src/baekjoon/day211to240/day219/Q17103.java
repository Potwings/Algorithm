package baekjoon.day211to240.day219;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 개선 사항
 * 입력받은 수에서 특정 소수를 빼준 후 해당 수도 소수인지 확인하는 방식으로 진행
 */
public class Q17103 {

  static int max = 1000000;
  static boolean[] decArr = new boolean[max + 1];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    decArr[1] = true;
    for (int i = 2; i <= Math.sqrt(max); i++) {
      if (!decArr[i]) {
        for (int j = i * i; j <= max; j += i) {
          decArr[j] = true;
        }
      }
    }

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      int count = 0;
      int num = Integer.parseInt(br.readLine());
      for (int j = 2; j <= num / 2; j++) {
        if(!decArr[j] && !decArr[num - j]) {
          count++;
        }
      }
      sb.append(count).append("\n");
    }
    System.out.println(sb);
  }
}

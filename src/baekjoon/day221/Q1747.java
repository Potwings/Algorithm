package baekjoon.day221;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 개선 사항
 * 입력값의 최대값이 1000000이지 결과값의 최대값은 아니다.
 */
public class Q1747 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int max = 2000000;
    boolean[] decArr = new boolean[max + 1];
    decArr[1] = true;
    for (int i = 2; i <= Math.sqrt(max); i++) {
      if (!decArr[i]) {
        for (int j = i * i; j <= max; j += i) {
          decArr[j] = true;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = N; i <= max; i++) {
      if (!decArr[i]) {
        sb.append(i);
        if (sb.reverse().toString().equals(String.valueOf(i))) {
          System.out.println(i);
          return;
        }
        sb.setLength(0);
      }
    }
  }

}

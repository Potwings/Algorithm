package baekjoon.day101to200.day181to190.day187;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 개선 사항 M과 N의 제곱근을 활용하여 대소 비교를 하면 확인해야하는 수들을 좀 더 줄일 수 있다.
 */
public class Q1977 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());

    double m1 = Math.sqrt(M);
    int start = m1 % 1 != 0 ? (int) m1 + 1 : (int) m1;
    int end = (int) Math.sqrt(N);

    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum += (i * i);
    }
    StringBuilder sb = new StringBuilder();
    if (sum > 0) {
      sb.append(sum).append("\n").append(start * start);
    } else {
      sb.append(-1);
    }
    System.out.println(sb);
  }

}

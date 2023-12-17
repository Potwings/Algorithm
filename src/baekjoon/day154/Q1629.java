package baekjoon.day154;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * B가 1일 경우 고려하지 않음
 * int의 최대값을 3승할 경우 long에서도 오버플로우가 발생한다. 따라서 모듈러 연산을 활용하여 오버플로우가 발생하지 않도록 한다.
 */
public class Q1629 {

  static int A;
  static int B;
  static int C;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    long result = getModResult(B);
    System.out.println(result);
  }

  public static long getModResult(int i) {
    if (i == 1) {
      return A % C;
    }
    long temp = getModResult(i / 2);

    if (i % 2 == 0) {
      // 짝수일 경우 둘로 나누어 계산
      return (temp % C) * (temp % C) % C;
    } else {
      return (temp * temp) % C * A % C;
    }
  }
}

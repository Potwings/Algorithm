package baekjoon.day216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 *
 * long의 범위 벗어나는 경우 고려하자 => 곱하는 대신 비교 대상을 나누어서 비교 진행
 */

public class Q1456 {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long start = Long.parseLong(st.nextToken());
    long end = Long.parseLong(st.nextToken());
    // end는 어떤 소수의 최소 2제곱이므로 소수의 최대값은 end의 제곱근이다.
    int decMax = (int) Math.ceil(Math.sqrt(end));
    boolean[] decArr = new boolean[decMax + 1]; // false인 경우 소수
    decArr[1] = true; // 1은 소수가 아니다.

    // 소수 탐색
    for (int i = 2; i <= Math.sqrt(decMax); i++) {
      if (!decArr[i]) {
        for (int j = i * i; j <= decMax; j += i) {
          decArr[j] = true;
        }
      }
    }

    int count = 0;
    // 탐색한 소수로 완전 소수 탐색
    for (int i = 2; i <= Math.sqrt(end); i++) {
      if (!decArr[i]) {
        // long 범위 넘어가는 경우 처리해야함
        long temp = i;
        while (i <= (double)end / temp) {
          if (i >= (double)start / temp) {
            count++;
          }
          temp *= i;
        }
      }
    }
    System.out.println(count);
  }
}

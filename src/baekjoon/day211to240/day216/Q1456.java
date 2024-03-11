package baekjoon.day211to240.day216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * start와 end는 long범위 이내이다.
 * 소수를 거듭 제곱 진행하는 과정에서는 long 범위를 초과할 수 있으므로
 * 시작 제곱을 i * i 대신 i로 진행하고
 * start와 end를 i로 나누어서 long 범위를 초과하지 않도록 해준다.
 * 이 때 나누어 떨어지지 않을 수 있으므로 나누기 전 double로 캐스팅해준다.
 */

public class Q1456 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long start = Long.parseLong(st.nextToken());
    long end = Long.parseLong(st.nextToken());
    // end는 어떤 소수의 최소 2제곱이므로 소수의 최대값은 end의 제곱근이다.
    int decMax = (int)Math.ceil(Math.sqrt(end));
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
        for (long j = i; j <= (double) end / i; j *= i) {
          if (j >= (double) start / i) {
            count++;
          }
        }
      }
    }
    System.out.println(count);
  }

}

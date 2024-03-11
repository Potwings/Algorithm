package baekjoon.day211to240.day217;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 개선 사항
 * N보다 크고, 2N보다 작거나 같은 조건을 놓침
 * 전체 범위가 크지 않으므로 전체 범위의 소수를 미리 구해둔 후 count만 확인하면 더 빠르다
 */
public class Q4948 {

  static int max = 123456 * 2;
  static boolean[] decArr;
  static int[] countArr;

  public static void main(String[] args) throws Exception {

    checkCount();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    StringBuilder sb = new StringBuilder();
    while (!(input = br.readLine()).equals("0")) {
      int N = Integer.parseInt(input);
      sb.append(countArr[2 * N] - countArr[N]).append("\n");
    }
    System.out.println(sb);
  }

  /*
   *  케이스 별 소수 개수 저장
   */
  public static void checkCount() {
    decArr = new boolean[max + 1];
    countArr = new int[max + 1];
    decArr[1] = true;
    for (int i = 2; i <= Math.sqrt(max); i++) {
      if (!decArr[i]) {
        for (int j = i * i; j <= max; j += i) {
          decArr[j] = true;
        }
      }
    }

    int count = 0;
    for (int i = 1; i <= max; i++) {
      if (!decArr[i]) {
        count++;
      }
      countArr[i] = count;
    }
  }
}

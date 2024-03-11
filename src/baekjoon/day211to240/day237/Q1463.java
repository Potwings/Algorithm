package baekjoon.day211to240.day237;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 개선 사항
 *
 * StackOverflow가 발생하여 Top-down 방식이 아닌 Bottom-Up 방식으로 구현
 * 불필요한 범위 탐색을 제거하기 위해 현재 수로 다음 수(더 큰 수)를 구하는 것이 아닌
 * 이전 수를 할용하여 현재 수를 구한다.
 * 구해야하는 수(N)까지만 탐색하도록 수정
 */
public class Q1463 {

  static int[] countArr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    countArr = new int[N + 1];
    countArr[1] = 0;
    setCount(N);
    System.out.println(countArr[N]);
  }

  public static void setCount(int num) {
    for (int i = 2; i <= num; i++) {
      countArr[i] = countArr[i - 1] + 1; // 항상 존재한다.
      if (i % 3 == 0) {
        // 3의 배수일 경우만 가능
        countArr[i] = Math.min(countArr[i], countArr[i / 3] + 1);
      }
      if (i % 2 == 0) {
        // 2의 배수일 경우만 가능
        countArr[i] = Math.min(countArr[i], countArr[i / 2] + 1);
      }
    }
  }
}
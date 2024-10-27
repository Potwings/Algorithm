package baekjoon.day241to268.day242;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10844 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[][] countArr = new long[N + 1][10]; // 특정 자리수(첫번째 인덱스)에서 끝자리(두번쨰 인덱스)인 숫자의 수
    for (int i = 1; i <= 9; i++) {
      countArr[1][i] = 1; // 한자리수에서 계단수는 0을 제외한 모든 수 이다.
    }
    for (int i = 2; i <= N; i++) {
      // 0과 9는 이전의 1과 8이 이미 나누어져 있으므로 따로 나머지를 구할 필요가 없다.
      countArr[i][0] = countArr[i - 1][1];
      countArr[i][9] = countArr[i - 1][8];
      for (int j = 1; j < 9; j++) {
        countArr[i][j] = (countArr[i - 1][j - 1] % 1000000000 + countArr[i - 1][j + 1] % 1000000000) % 1000000000;
      }
    }
    long result = 0;
    for (long count : countArr[N]) {
      result += count;
    }
    System.out.println(result % 1000000000);
  }
}

package baekjoon.day241to268.day246;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11057 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] D = new int[N + 1][10];
    Arrays.fill(D[1], 1); // 한자리에서는 모두 오르막 수이다.

    for (int i = 1; i <= N; i++) {
      for (int j = 0; j <= 9; j++) {
        for (int l = 0; l <= j; l++) {
          D[i][j] += D[i - 1][l];
        }
        D[i][j] %= 10007;
      }
    }

    int result = 0;
    for (int count : D[N]) {
      result += count;
    }
    System.out.println(result % 10007);
  }

}

package baekjoon.day266;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1904 {

  static int[] DP;

  static int divide = 15746;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    DP = new int[N + 1];
    DP[1] = 1;
    if (N > 1) {
      DP[2] = 2;
    }
    for (int i = 3; i <= N; i++) {
      DP[i] = (DP[i - 1] + DP[i - 2]) % divide;
    }
    System.out.println(DP[N] % 15746);
  }
}

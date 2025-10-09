package baekjoon.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1010 {

  static long[][] DP;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    // 팩토리얼 계산
    DP = new long[31][31];
    for (int i = 0; i <= 30; i++) {
      DP[i][0] = 1;
      DP[i][1] = i;
      DP[i][i] = 1;
    }

    StringTokenizer st = null;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      long result = solve(N, M);
      sb.append(result).append("\n");
    }

    System.out.println(sb);
  }

  // M개 중에 N개를 선택하는 경우 (조합)
  // 팩토리얼 활용
  public static long solve(int N, int M) {

    return combine(M, N); // M개 중 N개 선택
  }

  // 조합의 성질을 활용한 조합 계산
  public static long combine(int n, int r) {

    if (DP[n][r] > 0) {
      return DP[n][r];
    }

    if (DP[n][n - r] > 0) {
      return DP[n][n - r];
    }

    long result = combine(n - 1, r) + combine(n - 1, r - 1);
    DP[n][r] = result;
    return result;
  }
}

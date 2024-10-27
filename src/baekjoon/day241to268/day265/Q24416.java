package baekjoon.day241to268.day265;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q24416 {

  static long count1 = 0;
  static long count2 = 0;

  static long[] DP;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    solve1(num);
    DP = new long[num + 1];
    solve2(num);
    sb.append(count1).append(" ").append(count2);
    System.out.println(sb);
  }

  // 재귀 호출로 해결
  public static long solve1(int num) {
    if (num == 1 || num == 2) {
      count1++;
      return 1;
    } else {
      return solve1(num - 1) + solve1(num - 2);
    }
  }

  // DP로 해결
  public static long solve2(int num) {
    DP[1] = DP[2] = 1;
    for (int i = 3; i <= num; i++) {
      count2++;
      DP[i] = DP[i - 1] + DP[i - 2];
    }
    return DP[num];
  }
}

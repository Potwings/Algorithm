package baekjoon.day266;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11053 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] nums = new int[N];
    int[] DP = new int[N];
    int result = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      DP[i] = 1;
      nums[i] = Integer.parseInt(st.nextToken());
      for (int j = N - 1; j >= 0; j--) {
        if (nums[j] < nums[i]) {
          DP[i] = Math.max(DP[i], DP[j] + 1);
        }
      }
      result = Math.max(result, DP[i]);
    }
    System.out.println(result);
  }
}
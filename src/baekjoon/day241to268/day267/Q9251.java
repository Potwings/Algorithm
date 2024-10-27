package baekjoon.day241to268.day267;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9251 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int max = 0;
    char[] c1 = br.readLine().toCharArray();
    int length1 = c1.length;
    char[] c2 = br.readLine().toCharArray();
    int length2 = c2.length;
    int[][] DP = new int[length1 + 1][length2 + 1];
    for (int i = 1; i <= length1; i++) {
      for (int j = 1; j <= length2; j++) {
        if (c1[i - 1] == c2[j - 1]) {
          DP[i][j] = DP[i - 1][j - 1] + 1;
          max = Math.max(DP[i][j], max);
        } else {
          DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
        }
      }
    }
    System.out.println(max);
  }
}

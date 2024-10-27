package baekjoon.day241to268.day266;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] coast = new int[N + 1][3];
    StringTokenizer st = null;
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      coast[i][0] = Integer.parseInt(st.nextToken()) + Math.min(coast[i - 1][1], coast[i - 1][2]);
      coast[i][1] = Integer.parseInt(st.nextToken()) + Math.min(coast[i - 1][0], coast[i - 1][2]);
      coast[i][2] = Integer.parseInt(st.nextToken()) + Math.min(coast[i - 1][0], coast[i - 1][1]);
    }

    System.out.println(Math.min(Math.min(coast[N][0], coast[N][1]), coast[N][2]));
  }
}

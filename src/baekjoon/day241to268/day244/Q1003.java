package baekjoon.day241to268.day244;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1003 {

  static int[][] D;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int[] numArr = new int[T];
    int max = 1; // 최소 배열의 길이는 2
    for (int i = 0; i < T; i++) {
      int num = Integer.parseInt(br.readLine());
      numArr[i] = num;
      max = Math.max(num, max);
    }
    D = new int[max + 1][2];
    D[0][0] = 1;
    D[1][1] = 1;
    for (int i = 2; i <= max; i++) {
      D[i][0] = D[i - 1][0] + D[i - 2][0];
      D[i][1] = D[i - 1][1] + D[i - 2][1];
    }
    StringBuilder sb = new StringBuilder();
    for (int num : numArr) {
      sb.append(D[num][0]).append(" ").append(D[num][1]).append("\n");
    }
    System.out.println(sb);
  }
}

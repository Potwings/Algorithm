package baekjoon.day271;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15652 {

  static int N, M;
  static int[] resultArr;
  static StringBuilder sb;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    resultArr = new int[M];
    sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      resultArr[0] = i;
      DFS(i, 1);
    }
    System.out.println(sb.toString().trim());
  }

  public static void DFS(int start, int depth) {
    if (depth == M) {
      for (int result : resultArr) {
        sb.append(result).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = start; i <= N; i++) {
      resultArr[depth] = i;
      DFS(i, depth + 1);
    }
  }
}

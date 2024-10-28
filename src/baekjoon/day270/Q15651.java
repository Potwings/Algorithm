package baekjoon.day270;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15651 {

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
      DFS(1);
    }
    System.out.println(sb.toString().trim());
  }

  public static void DFS(int depth) {

    if (depth == M) {
      for (int num : resultArr) {
        sb.append(num).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      resultArr[depth] = i;
      DFS(depth + 1);
    }
  }

}

package baekjoon.day269;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15650 {

  static int N, M;
  static int[] resultArr;
  static boolean[] visitArr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    resultArr = new int[M];
    for (int i = 1; i <= N - M + 1; i++) {
      visitArr = new boolean[N + 1];
      resultArr[0] = i;
      visitArr[i] = true;
      DFS(i, 1);
    }
    System.out.println(sb.toString().trim());
  }

  public static void DFS(int start, int depth) {
    if (depth == M) {
      for (int num : resultArr) {
        sb.append(num).append(" ");
      }
      sb.append("\n");
      return;
    }

    // 1부터가 아닌 나보다 큰 수부터 탐색 진행
    for (int i = start + 1; i <= N; i++) {
      if (!visitArr[i]) {
        visitArr[i] = true;
        resultArr[depth] = i;
        DFS(i, depth + 1);
        visitArr[i] = false;
      }
    }
  }
}
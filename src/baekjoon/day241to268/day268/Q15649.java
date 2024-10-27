package baekjoon.day241to268.day268;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649 {

  static boolean[] visitArr;
  static int[] numArr; // 어차피 덮어쓸 수 있다.
  static int N, M;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    for (int i = 1; i <= N; i++) {
      visitArr = new boolean[N + 1];
      visitArr[i] = true;
      numArr = new int[M];
      numArr[0] = i;
      DFS(1);
    }
    System.out.println(sb);
  }

  public static void DFS(int count) {
    if (count == M) {
      for (int i = 0; i < M; i++) {
        sb.append(numArr[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (!visitArr[i]) {
        numArr[count] = i;
        visitArr[i] = true;
        DFS(count + 1);
        visitArr[i] = false; // 다른 case에서는 활용할 수 있도록
      }
    }
  }
}

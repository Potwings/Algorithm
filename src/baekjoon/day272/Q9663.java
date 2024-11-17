package baekjoon.day272;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9663 {

  static int N;
  static long count;
  static int[] queenArr;
  static boolean[] visitArr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    queenArr = new int[N];
    visitArr = new boolean[N];
    DFS(0);
    System.out.println(count);
  }

  public static void DFS(int depth) {

    if (!checkDia(depth - 1)) {
      // 한 대각선에 존재하지 않는 경우
      return;
    }

    if (depth == N) {
      count++;
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visitArr[i]) {
        queenArr[depth] = i;
        visitArr[i] = true;
        DFS(depth + 1);
        visitArr[i] = false;
      }
    }
  }

  public static boolean checkDia(int depth) {
    for (int i = 0; i < depth; i++) {
      // 지금 추가된 값을 이전 값들과 비교
      if (Math.abs(queenArr[depth] - queenArr[i]) == depth - i) {
        return false;
      }
    }
    return true;
  }
}
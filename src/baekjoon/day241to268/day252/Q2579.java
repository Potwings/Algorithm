package baekjoon.day241to268.day252;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2579 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N + 1];
    int[] D = new int[N + 1];
    A[1] = Integer.parseInt(br.readLine());
    D[1] = A[1];
    if (N == 1) {
      System.out.println(D[N]);
      return;
    }
    A[2] = Integer.parseInt(br.readLine());
    D[2] = A[1] + A[2];
    for (int i = 3; i <= N; i++) {
      A[i] = Integer.parseInt(br.readLine());
      // D[i-2]는 A[i-2]를 포함하기 때문에 A[i-1]은 사용 불가하다.
      D[i] = Math.max(D[i - 3] + A[i - 1], D[i - 2]) + A[i];
    }
    System.out.println(D[N]);
  }
}

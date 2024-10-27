package baekjoon.day241to268.day247;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * <p>
 * <p>
 * N이 1이 들어올 경우 고려
 * DP는 항상 시작점이 있다는 것을 생각하자
 * StringTokenizer를 두개 만들어서 진행하면 반복을 줄일 수 있다.(현재값보다 뒤의 값은 필요없기 때문)
 * -> 허나 StringTokenizer를 두개 생성하는 과정에서 오버헤드가 발생하여 성능이 더 좋지는 않다.
 */
public class Q9465 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st1, st2;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      int[][] scoreArr = new int[2][N + 1];
      int[][] D = new int[2][N + 1];
      st1 = new StringTokenizer(br.readLine());
      st2 = new StringTokenizer(br.readLine());
      scoreArr[0][1] = Integer.parseInt(st1.nextToken());
      scoreArr[1][1] = Integer.parseInt(st2.nextToken());
      D[0][1] = scoreArr[0][1];
      D[1][1] = scoreArr[1][1];
      for (int k = 2; k <= N; k++) {
        scoreArr[0][k] = Integer.parseInt(st1.nextToken());
        scoreArr[1][k] = Integer.parseInt(st2.nextToken());
        D[0][k] = Math.max(D[1][k - 1], D[1][k - 2]) + scoreArr[0][k];
        D[1][k] = Math.max(D[0][k - 1], D[0][k - 2]) + scoreArr[1][k];
      }
      sb.append(Math.max(D[0][N], D[1][N])).append("\n");
    }
    System.out.println(sb);
  }
}

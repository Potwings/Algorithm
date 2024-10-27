package baekjoon.day241to268.day255;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11722 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    int[] D = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int result = 1;
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
      D[i] = 1;
      for (int j = i - 1; j >= 0; j--) {
        if (A[j] > A[i]) {
          D[i] = Math.max(D[i], D[j] + 1);
        }
      }
      result = Math.max(result, D[i]);
    }
    System.out.println(result);
  }
}

package baekjoon.day241to268.day256;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11054 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    int[] D = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    int result = 0;
    // 중간값 변경
    for (int i = 0; i < N; i++) {
      // 증가 부분 (중간값까지는 증가해야한다)
      for (int j = 0; j <= i; j++) {
        D[j] = 1;
        // 이전값 탐색 (k : 이전 값)
        for (int k = j - 1; k >= 0; k--) {
          if (A[j] > A[k]) {
            // 이전값보다 크면 count + 1;
            D[j] = Math.max(D[k] + 1, D[j]);
          }
        }
      }
      result = Math.max(D[i], result); // 증가만 하는 경우를 위한 결과값 저장

      // 감소 부분
      for (int j = i + 1; j < N; j++) {
        D[j] = D[i]; // 증가한 수열의 길이는 보장된다
        // 이전값 탐색 (k : 이전 값)
        for (int k = j - 1; k >= i; k--) {
          if (A[j] < A[k]) {
            // 이전값보다 작으면 count + 1 ;
            D[j] = Math.max(D[k] + 1, D[j]);
          }
        }
        // 증가는 i번째에서 종료되어야 하나 감소는 언제 종료되어도 상관없다.
        result = Math.max(D[j], result);
      }
    }
    System.out.println(result);
  }
}

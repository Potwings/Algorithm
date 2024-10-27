package baekjoon.day241to268.day254;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11053re {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] numArr = new int[N];
    int[] D = new int[N];
    int result = 1;
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      numArr[i] = num;
      D[i] = 1; // 1로 초기화
      for (int j = i - 1; j >= 0; j--) {
        if (numArr[j] < num) {
          D[i] = Math.max(D[i], D[j] + 1);
        }
      }
      result = Math.max(D[i] , result);
    }
    System.out.println(result);
  }

}

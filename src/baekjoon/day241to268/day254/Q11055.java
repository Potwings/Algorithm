package baekjoon.day241to268.day254;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11055 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] numArr = new int[N];
    int[] D = new int[N];
    int result = 0;
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      numArr[i] = num;
      D[i] = num; // 합의 최소는 자기 자신의 값이다.
      for (int j = i - 1; j >= 0; j--) {
        if (num > numArr[j]) {
          D[i] = Math.max(D[j] + num, D[i]);
        }
      }
      result = Math.max(D[i], result);
    }
    System.out.println(result);
  }

}

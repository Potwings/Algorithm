package baekjoon.day241to268.day246;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11727 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] D = new int[1001];
    D[1] = 1;
    D[2] = 3;
    for (int i = 3; i <= N; i++) {
      /*
       * i - 1번째의 뒤에 1x2 추가하는 경우
       * i - 2번째의 뒤에 2x2 추가하는 경우
       * i - 2번째의 뒤에 2x1 2개 추가하는 경우
       */
      D[i] =(D[i - 1] + D[i - 2] + D[i - 2]) % 10007;
    }
    System.out.println(D[N]);
  }
}

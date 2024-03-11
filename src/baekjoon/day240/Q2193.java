package baekjoon.day240;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2193 {

  // 0과 1의 개수 이용한 DP 진행 방법
  static long[][] D;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    D = new long[N+2][2];
    D[1][1] = 1; // 시작은 무조건 1
    D[1][0] = 0;
    // 어차피 N까지 전부 진행해야 결과값 구할 수 있으므로 반복문으로 진행
    for(int i = 2; i <= N; i++) {
      D[i][0] = D[i - 1][0] + D[i - 1][1];
      D[i][1] = D[i - 1][0];
    }
    System.out.println(D[N][0] + D[N][1]);
  }

  // 피보나치 수를 점화식으로 활용한 방법
//  static long[] D;
//
//  public static void main(String[] args) throws Exception {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int N = Integer.parseInt(br.readLine());
//    D = new long[N + 2]; // N이 1일 경우에도 1과 2는 가능하게 하기 위하여 N + 2 진행 (1 <= N <= 90)
//    D[1] = 1;
//    D[2] = 1;
//    System.out.println(fibo(N)); // 해당 문제의 점화식은 피보나치 수와 동일하다
//  }
//
//  public static long fibo(int num) {
//
//    long result = D[num];
//    if (result == 0) {
//      D[num] = fibo(num - 1) + fibo(num - 2);
//    }
//    return D[num];
//  }

}

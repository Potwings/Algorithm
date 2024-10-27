package baekjoon.day241to268.day258;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1912 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N + 1];
    int[] D = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
      D[i] = Math.max(D[i - 1] + A[i], A[i]); // 이전 구간 포함 or 현재부터 구간 다시 시작
      max = Math.max(D[i], max);
    }
    System.out.println(max);
  }
}

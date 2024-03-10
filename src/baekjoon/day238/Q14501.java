package baekjoon.day238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 특정 일자에 수익이 0일 경우 이전 일자의 수익을 불러와야 한다.
 * 특정 일자의 수익이 0이 아니더라도 이전 일자보다 적을 경우 이전 일자의 값으로 대체한다.
 */
public class Q14501 {

  static int[] D;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    D = new int[N + 2];
    StringTokenizer st;
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int day = Integer.parseInt(st.nextToken());
      int pay = Integer.parseInt(st.nextToken());
      int balance = D[i] + pay; // 현재 일자 금액 + 상담 종료 후 벌어들인 금액
      for (int j = i + day; j <= N + 1; j++) {
        D[j] = Math.max(D[j], balance); // 해당 시점 이후로는 최소 현재 잔고를 유지한다.
      }
    }
    System.out.println(D[N + 1]);
  }
}

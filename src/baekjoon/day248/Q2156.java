package baekjoon.day248;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2156 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] dp0 = new int[N + 1]; // 마자막 잔은 포함하지 않는 경우
    int[] dp1 = new int[N + 1]; // 마자막 한 잔만 포함하는 경우
    int[] dp2 = new int[N + 1]; // 마자막 두 잔 포함하는 경우

    int first = Integer.parseInt(br.readLine());
    dp1[1] = first;
    dp2[1] = first; // 처음에는 수가 하나밖에 없으므로
    for (int i = 2; i <= N; i++) {
      int num = Integer.parseInt(br.readLine());
      // 마지막 잔을 포함하지 않는 경우는 이전의 어떤 경우에서도 만들어질 수 있다.
      dp0[i] = Math.max(Math.max(dp0[i - 1], dp1[i - 1]), dp2[i - 1]);
      dp1[i] = dp0[i - 1] + num;
      dp2[i] = dp1[i - 1] + num;
    }
    System.out.println(Math.max(Math.max(dp0[N], dp1[N]), dp2[N]));
  }
}

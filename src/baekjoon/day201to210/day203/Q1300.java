package baekjoon.day201to210.day203;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1300 {

  static int N;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    int min = 1;
    int max = k;

    /**
     * now가 커질 수록 index값은 증가한다.
     * index값에는 자신과 동일한 수들도 포함되어있기 때문에
     *
     * x(배열 값)의 idx가 k보다 작을 경우는 now를 증가시켜야하며
     * x의 idx가 k보다 클 경우는 B[k]의 경우도 포함할 수 있으므로
     * 크거나 같을 경우 now값을 포함하여 값을 조정해야한다.
     *
     * 자바에서 나눗셈은 내림방식으로 계산하므로 now == max가 계속 반복되는 경우는 min == max 경우를 제외하고는 없다.
     */
    while (min < max) {
      int now = (min + max) / 2;
      int idx = getIdx(now);
      if (idx < k) {
        // k보다 작을 경우 증가시켜야함
        min = now + 1;
      } else {
        // k보다 클 경우 해당 값 포함하여 감소시켜야함.
        max = now;
      }
    }
    System.out.println(max);
  }

  /**
   * 해당 수보다 작은 수의 개수(일차원 배열의 인덱스)를 확인하는 메소드
   *
   * 이차원 배열에서 i번째 배열은 i의 배수들의 집합이므로 num보다 작은 수들은 num을 i로 나눈 몫이다.
   * 단 이차원 배열은 N*N형식이므로 N보다 개수가 적어야 한다.
   */
  public static int getIdx(int num) {
    int count = 0;
    for (int i = 1; i <= N; i++) {
      int lineCount = num / i;
      if (lineCount == 0) {
        break;
      }
      count += Math.min(lineCount, N);
    }
    return count;
  }
}

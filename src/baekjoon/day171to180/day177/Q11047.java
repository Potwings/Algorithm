package baekjoon.day171to180.day177;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항 동전이 K값보다 작을 경우만 나눗셈 진행하는 조건 추가
 */
public class Q11047 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] coins = new int[N];
    for (int i = N - 1; i >= 0; i--) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    int count = 0;
    for (int coin : coins) {

      if (coin > K) {
        continue;
      }

      count += K / coin;
      K %= coin;

      if (K == 0) {
        break;
      }
    }
    System.out.println(count);
  }

}

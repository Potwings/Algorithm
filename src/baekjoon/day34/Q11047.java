package baekjoon.day34;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
 * 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 * 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
 * <p>
 * 출력
 * 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
 */
public class Q11047 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 큰 수부터 나누면서 나머지가 0이 될 때까지 진행한다.
        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            int coin = coins[i];

            if (coin > K) {
                // 남은 금액보다 동전의 가치가 더 클 경우 다음 동전 진행
                continue;
            }

            result += K / coin;
            K %= coin;

            if (K == 0) {
                break;
            }
        }

        System.out.println(result);
    }
}

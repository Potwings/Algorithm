package baekjoon.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
 *
 * 예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로,
 * 이들 소수의 합은 620이고, 최솟값은 61이 된다.
 *
 * 입력
 * 입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.
 * M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
 *
 * 출력
 * M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다.
 * 단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
 */

/**
 * 개선 사항
 * 소수 문제 풀이 시 1에 주의하자
 */
public class Q2581 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int decimalSum = 0;
        int minDecimal = 0;

        all:
        for (int i = M; i <= N; i++) {

            if(i == 1) continue; // 1은 소수가 아니므로 제외

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue all; // i가 소수가 아닐 경우 다음 수 진행
                }
            }

            if (minDecimal == 0) {
                // 처음 발생한 소수는 minDecimal에 저장
                minDecimal = i;
            }
            // 소수들의 합 계산
            decimalSum += i;
        }

        if (decimalSum == 0) {
            // 소수가 없을 경우 -1 출력
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(decimalSum);
        sb.append("\n");
        sb.append(minDecimal);

        System.out.println(sb.toString());
    }
}

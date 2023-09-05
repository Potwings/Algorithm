package baekjoon.day10to50.day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
 * 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
 * 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다.
 * 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
 * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
 * <p>
 * 출력
 * 첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.
 */

/**
 * 개선 사항
 * 해당 자리의 수의 값을 가져올 때
 * String으로 변환하여 가져오는 것 보다
 * 10진수로 나눈 나머지를 가져오는 것이 더 빠르다.
 */
public class Q2231 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 1; i <= N; i++) {
            // 생성자가 N보다 클 순 없으므로 N까지 수행
            int num = i;
            int sum = i;

            while (num > 0) {
                sum += num % 10; // 마지막 자리수를 구하여 합한다.
                num /= 10; // 다음 자리수 구하기 위해 10으로 나누어준다. 나눈 결과가 0일 경우 break
            }

            if (sum == N) {
                // 분해합이 N일 경우 result는 N의 생성자이다.
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
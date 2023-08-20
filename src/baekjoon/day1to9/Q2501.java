package baekjoon.day1to9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 어떤 자연수 p와 q가 있을 때, 만일 p를 q로 나누었을 때 나머지가 0이면 q는 p의 약수이다.
 * 두 개의 자연수 N과 K가 주어졌을 때, N의 약수들 중 K번째로 작은 수를 출력하는 프로그램을 작성하시오.
 * <p>
 * 첫째 줄에 N과 K가 빈칸을 사이에 두고 주어진다. N은 1 이상 10,000 이하이다. K는 1 이상 N 이하이다.
 * 첫째 줄에 N의 약수들 중 K번째로 작은 수를 출력한다. 만일 N의 약수의 개수가 K개보다 적어서 K번째 약수가 존재하지 않을 경우에는 0을 출력하시오.
 */
public class Q2501 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        int result = 0;
        for (int i = 1; i <= N; i++) {

            if (N % i == 0) {
                // 약수가 발견되었을 경우 result에 담아주고 count를 추가
                count++;

                if (count == K) {
                    // K번째일 경우 약수(i)를 result에 담아준 후 반복문 종료
                    result = i;
                    break;
                }
            }
        }
        System.out.println(result); // result 출력. K번째가 없을 경우 result 기본값(0) 출력
    }
}

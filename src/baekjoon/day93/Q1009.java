package baekjoon.day93;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 컴퓨터가 10대이므로 10으로 나눈 나머지인 1의 자리 수를 생각하면 된다.
 * 이 때 특정 수들은 제곱을 진행하였을 때 1의 자리의 수에 대한 특징이 존재한다.
 * 1, 5, 6, 10의 경우 제곱을 진행해도 1의 자리는 항상 동일하다.
 *
 * 4의 경우 4,6으로 반복된다
 * 9의 경우 9,1로 반복된다.
 *
 * 2의 경우 2,4,8,6으로 반복된다.
 * 3의 경우 3,9,7,1로 반복된다.
 * 7의 경우 7,9,3,1로 반복된다.
 * 8의 경우 8,4,2,6로 반복된다.
 *
 * 위의 특징들을 이용하여 곱계산을 줄일 수 있다.
 */
public class Q1009 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = a % 10;
            for (int j = 1; j < b; j++) {
                result = (result * a) % 10;
            }
            sb.append(result == 0 ? 10 : result).append("\n");
        }

        System.out.println(sb);
    }
}

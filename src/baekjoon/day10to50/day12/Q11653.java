package baekjoon.day10to50.day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제
 * 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
 * <p>
 * 출력
 * N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.
 */

/**
 * 개선 사항
 * 결과가 알아서 작은 수부터 나오기 때문에
 * 굳이 count를 확인할 필요 없이 그냥 나올 떄마다 써주면 된다...
 */

public class Q11653 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> resultMap = new HashMap<>();

        if (N == 1) return;

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (N % i == 0) {
                sb.append(i).append("\n");
                N /= i; // 인수가 구해졌을 경우 몫에서 다음 인수를 구한다.
                i--; //이미 i보다 작은 수들은 인수로 없기 때문에 i--만 진행한 후 다시 루프 진행하면 된다.
            }
        }

        System.out.println(sb.toString());
    }
}

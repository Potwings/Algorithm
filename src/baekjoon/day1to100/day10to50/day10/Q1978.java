package baekjoon.day1to100.day10to50.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 *
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 */

public class Q1978 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        getNum :
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num == 1) // 1은 약수가 자기 자신뿐이므로 continue;
                continue;

            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    // 1과 num을 제외한 수 중 나누어 떨어뜨리는 수가 있을 경우 소수가 아니다.
                    continue getNum; // 다음 num을 진행한다.
                }
            }
            count++; // 1과 num을 제외한 수 중 나누어 떨어뜨리는 수가 없을 경우 count 추가
        }

        System.out.println(count);
    }
}
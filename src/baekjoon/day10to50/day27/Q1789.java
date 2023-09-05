package baekjoon.day10to50.day27;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
 * <p>
 * 입력
 * 첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.
 * <p>
 * 출력
 * 첫째 줄에 자연수 N의 최댓값을 출력한다.
 */

/**
 * 개선 사항
 * num과 count를 분리할 필요 없이 마지막으로 추가한 num값을 활용하면 된다.
 */
public class Q1789 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        /**
         * 자연수 N의 최댓값이므로 작은 수부터 더하는 중 S보다 합이 커졌을 때 개수를 출력하면 된다.
         * 합이 해당 값보다 커졌을 경우 그 전까지 가지고 있던 수에서 빼고 더 큰 수를 추가해야하기 때문
         * 만일 합과 S가 같은 경우에도 반복을 진행하도록 하여 동일하게 count - 1의 값이 정답이 되도록 해주었다.
         */
        int num = 1;
        long sum = 0;
        while (sum <= S) {
            sum += num;
            num++;
        }

        System.out.println(num-2);
    }
}

package baekjoon.day1to100.day10to50.day29;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * 춘향이는 편의점 카운터에서 일한다.
 * 손님이 2원짜리와 5원짜리로만 거스름돈을 달라고 한다. 2원짜리 동전과 5원짜리 동전은 무한정 많이 가지고 있다.
 * 동전의 개수가 최소가 되도록 거슬러 주어야 한다. 거스름돈이 n인 경우, 최소 동전의 개수가 몇 개인지 알려주는 프로그램을 작성하시오.
 * 예를 들어, 거스름돈이 15원이면 5원짜리 3개를,
 * 거스름돈이 14원이면 5원짜리 2개와 2원짜리 2개로 총 4개를,
 * 거스름돈이 13원이면 5원짜리 1개와 2원짜리 4개로 총 5개를 주어야 동전의 개수가 최소가 된다.
 * <p>
 * 입력
 * 첫째 줄에 거스름돈 액수 n(1 ≤ n ≤ 100,000)이 주어진다.
 * <p>
 * 출력
 * 거스름돈 동전의 최소 개수를 출력한다. 만약 거슬러 줄 수 없으면 -1을 출력한다.
 */
public class Q14916 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /**
         * 동전 개수가 가장 적게 하기 위해 우선 5원짜리가 가장 많이 나올 수 있도록 나눈다.
         * 만일 나누어떨어지지 않으면 5원짜리를 2원짜리로 변경하면서 확인한다.
         * 모두 2원짜리로 해도 나누어지지 않을 경우 -1을 반환한다.
         */
        int five = N / 5;
        int remain = N % 5;
        int two = 0;
        while (remain > 0) {

            two = remain / 2;
            if (remain % 2 == 0) {
                break;
            }

            // 거스름돈이 안나누어 떨어질 경우 5원짜리 하나를 제외하고 다시 진행
            five--;
            remain += 5;
            if (five < 0) {
                // 5원짜리를 이미 모두 제외했을 경우 loop 중단
                break;
            }
        }

        // 5원짜리의 개수가 음수일 경우 -1 반환, 그 이외는 동전 수의 합 반환
        System.out.println(five < 0 ? -1 : five + two);
    }
}

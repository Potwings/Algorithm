package baekjoon.day1to9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
 * 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
 * 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
 */

/**
 * while loop 통하여 해결하려했으나 시간 초과 발생
 * 아래와 같이 개선
 */
public class Q2869 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Integer.parseInt(st.nextToken()) * 1.0;
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 마지막 날 낮에 올라갈 높이를 미리 빼두고 매일 높이 변화량으로 나눠서 계산한다.
        // 미리 마지막 날의 올라갈 높이를 처리했기 때문에 + 1 한다.
        int day = (int) (Math.ceil((V - A) / (A - B)) + 1);

        System.out.println(day);
    }
}

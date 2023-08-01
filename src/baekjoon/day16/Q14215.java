package baekjoon.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제
 * 영선이는 길이가 a, b, c인 세 막대를 가지고 있고, 각 막대의 길이를 마음대로 줄일 수 있다.
 * 영선이는 세 막대를 이용해서 아래 조건을 만족하는 삼각형을 만들려고 한다.
 * - 각 막대의 길이는 양의 정수이다
 * - 세 막대를 이용해서 넓이가 양수인 삼각형을 만들 수 있어야 한다.
 * - 삼각형의 둘레를 최대로 해야 한다.
 * a, b, c가 주어졌을 때, 만들 수 있는 가장 큰 둘레를 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 a, b, c (1 ≤ a, b, c ≤ 100)가 주어진다.
 * <p>
 * 출력
 * 첫째 줄에 만들 수 있는 가장 큰 삼각형의 둘레를 출력한다.
 */

/**
 * 파라미터로 전달 받은 값을 확인이나 다른 작업이 필요 없으므로
 * for문을 통하여 Integer.parseInt(st.nextToken()); 중복 작업의 코드량을 줄여줄 수 있다.
 */
public class Q14215 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] bars = new int[3];

        for(int i = 0; i < 3; i++){
            bars[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(bars);

        /**
         * 삼각형의 조건인 가장 긴 변이 나머지 두변의 합보다 작아야 한다는 조건을 맞춰야한다.
         * 가장 긴 변이 조건에 부합하지 않도록 길 경우
         * 최대 둘레를 구하기 위해 짧은 두변의 합보다 1을 더 줄여 삼각형 조건을 만족시켜준 후 둘레를 구한다
         */
        if (bars[2] >= bars[0] + bars[1]) {
            System.out.println((bars[0] + bars[1]) * 2 - 1);
        } else {
            // 삼각형의 조건을 만족시킬 경우 세 막대의 길이의 합을 출력한다.
            System.out.println(bars[0] + bars[1] + bars[2]);
        }
    }
}

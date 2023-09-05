package baekjoon.day10to50.day16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제
 * 삼각형의 세 변의 길이가 주어질 때 변의 길이에 따라 다음과 같이 정의한다.
 * Equilateral : 세 변의 길이가 모두 같은 경우
 * Isosceles : 두 변의 길이만 같은 경우
 * Scalene : 세 변의 길이가 모두 다른 경우
 * 단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다. 예를 들어 6, 3, 2가 이 경우에 해당한다. 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
 * 세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.
 * <p>
 * 입력
 * 각 줄에는 1,000을 넘지 않는 양의 정수 3개가 입력된다. 마지막 줄은 0 0 0이며 이 줄은 계산하지 않는다.
 * <p>
 * 출력
 * 각 입력에 맞는 결과 (Equilateral, Isosceles, Scalene, Invalid) 를 출력하시오.
 */
public class Q5073 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                // 0이 나올 경우 종료
                break;
            }

            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] sides = {a, b, c};
            Arrays.sort(sides);

            String result = null;
            if (sides[2] >= sides[1] + sides[0]) {
                // 삼각형이 아닐 경우 아래 조건 확인
                result = "Invalid";
            } else if (a == b && b == c) {
                // 정삼각형 확인
                result = "Equilateral";
            } else if (a == b || b == c || c == a) {
                // 이등변 삼각형 확인
                result = "Isosceles";
            } else {
                // 그 이외는 부등변 삼각형이다
                result = "Scalene";
            }

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}

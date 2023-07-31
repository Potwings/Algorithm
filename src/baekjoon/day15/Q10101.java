package baekjoon.day15;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * 창영이는 삼각형의 종류를 잘 구분하지 못한다. 따라서 프로그램을 이용해 이를 외우려고 한다.
 * 삼각형의 세 각을 입력받은 다음,
 * 세 각의 크기가 모두 60이면, Equilateral
 * 세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
 * 세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
 * 세 각의 합이 180이 아닌 경우에는 Error
 * 를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 총 3개의 줄에 걸쳐 삼각형의 각의 크기가 주어진다. 모든 정수는 0보다 크고, 180보다 작다.
 *
 * 출력
 * 문제의 설명에 따라 Equilateral, Isosceles, Scalene, Error 중 하나를 출력한다.
 */
public class Q10101 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());


        String result = null;
        if (a + b + c != 180) {
            // 세각의 합이 180이 아닐 경우 다른케이스 고려하지 않아도 되므로 우선 처리
            result = "Error";
        } else if (a == 60 && b == 60) {
            // 두 각이 60이 아닐 경우 나머지 하나도 60이 아니므로 위와 같이 처리
            result = "Equilateral";
        } else if (a == b || b == c || a == c) {
            // 같은 두 각이 있을 경우 Isosceles 처리
            result = "Isosceles";
        } else {
            // 그 이외는 모두 Scalene이다.
            result = "Scalene";
        }

        System.out.println(result);
    }
}

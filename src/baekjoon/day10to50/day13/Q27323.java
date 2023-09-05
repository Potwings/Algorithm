package baekjoon.day10to50.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * 정수 A, B 가 주어진다. 세로 길이가 A cm, 가로 길이가 B cm 인 아래와 같은 직사각형의 넓이를 cm2 단위로 구하시오.
 */
public class Q27323 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        System.out.println(A * B);
    }
}

package baekjoon.day10to50.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * "한 변의 길이가 1인 정사각형을 아래 그림과 같이 겹치지 않게 빈틈없이 계속 붙여 나간다. 가장 아랫부분의 정사각형이 n개가 되었을 때, 실선으로 이루어진 도형의 둘레의 길이를 구하시오."
 * 가장 아랫부분의 정사각형 개수가 주어지면 그에 해당하는 답을 출력하는 프로그램을 만들어 형석이를 도와주자!
 *
 * 입력
 * 첫 번째 줄에 가장 아랫부분의 정사각형 개수 n이 주어진다. (1 ≤ n ≤ 10^9)
 *
 * 출력
 * 첫 번째 줄에 형석이가 말해야 하는 답을 출력한다.
 */
public class Q15894 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine()); // 최대로 입력받는 값이 10억이라 4배 하였을 경우 int의 최대값을 넘어가게 된다

        // n이 추가될 때 마다 위, 아래, 오른쪽, 왼쪽 각각 길이가 +1씩 된다.
        System.out.println(4 * n);
    }
}

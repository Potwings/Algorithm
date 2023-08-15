package baekjoon.day28;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * 다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있다. 다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다.
 * 다솜이가 할 수 있는 행동은 S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다.
 * 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.
 * 예를 들어 S=0001100 일 때,
 * <p>
 * 전체를 뒤집으면 1110011이 된다.
 * 4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.
 * 하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.
 * <p>
 * 문자열 S가 주어졌을 때, 다솜이가 해야하는 행동의 최소 횟수를 출력하시오.
 * <p>
 * 입력
 * 첫째 줄에 문자열 S가 주어진다. S의 길이는 100만보다 작다.
 * <p>
 * 출력
 * 첫째 줄에 다솜이가 해야하는 행동의 최소 횟수를 출력한다.
 */
public class Q1439 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        // 연속적으로 나오는 문자 블록의 개수를 확인한다
        int block = 1;
        char before = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            char now = S.charAt(i);
            if (before != now) {
                before = now;
                block++;
            }
        }

        // 블록 수를 2로 나누었을 때의 몫만큼만 변경하면 된다.
        System.out.println(block / 2);
    }

}
package baekjoon.day43;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 문제
 * 문자열 S가 주어졌을 때, S의 서로 다른 부분 문자열의 개수를 구하는 프로그램을 작성하시오.
 * 부분 문자열은 S에서 연속된 일부분을 말하며, 길이가 1보다 크거나 같아야 한다.
 * 예를 들어, ababc의 부분 문자열은 a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc, abab, babc, ababc가 있고, 서로 다른것의 개수는 12개이다.
 * <p>
 * 입력
 * 첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000 이하이다.
 * <p>
 * 출력
 * 첫째 줄에 S의 서로 다른 부분 문자열의 개수를 출력한다.
 */
public class Q11478 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 중복 제거를 위하여 Set사용
        Set<String> strSet = new HashSet<>();
        String input = br.readLine();

        // j부터 i까지의 문자열을 잘라서 불러오도록 진행
        for (int i = input.length(); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                strSet.add(input.substring(j, i));
            }
        }
        System.out.println(strSet.size());
    }
}

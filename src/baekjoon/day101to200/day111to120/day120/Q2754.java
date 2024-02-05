package baekjoon.day101to200.day111to120.day120;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 개선 사항
 * 계속 char쓰다보니까 String equals로 비교를 까먹는다...
 * 반드시 String은 equals로 비교하자
 */
public class Q2754 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (input.equals("F")) {
            System.out.println(0.0);
            return;
        }

        double score = 4.0 - input.charAt(0) + 'A';
        if (input.charAt(1) == '+') {
            score += 0.3;
        } else if (input.charAt(1) == '-') {
            score -= 0.3;
        }
        System.out.println(score);
    }
}

package baekjoon.day142;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10039 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
        for (int i = 0; i < 5; i++) {
            int score = Integer.parseInt(br.readLine());
            total += Math.max(score, 40);
        }

        System.out.println(total / 5);
    }
}

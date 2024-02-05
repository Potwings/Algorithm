package baekjoon.day101to200.day101to110.day101;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1100 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        for (int i = 0; i < 8; i++) {
            String input = br.readLine();
            int start = 0;
            if (i % 2 > 0) {
                // 홀수번째 줄일경우 두번째 칸부터 하얀 칸이다.
                start = 1;
            }
            for (int j = start; j < 8; j += 2) {
                if (input.charAt(j) == ('F')) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}

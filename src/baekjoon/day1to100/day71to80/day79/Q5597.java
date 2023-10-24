package baekjoon.day1to100.day71to80.day79;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5597 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] studentNums = new boolean[30];
        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            studentNums[num - 1] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            if (!studentNums[i]) {
                sb.append(i + 1).append("\n");
            }
        }
        System.out.println(sb);
    }
}

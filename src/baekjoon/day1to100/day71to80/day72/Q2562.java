package baekjoon.day1to100.day71to80.day72;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2562 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int idx = -1;

        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > max) {
                max = num;
                idx = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(idx);
        System.out.println(sb);

    }
}

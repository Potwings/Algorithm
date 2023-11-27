package baekjoon.day134;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2577 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        int[] count = new int[10];
        while (result > 0) {
            count[result % 10]++; // 마지막 자리 수 개수 증가
            result /= 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int num : count) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}

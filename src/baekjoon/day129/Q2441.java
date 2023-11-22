package baekjoon.day129;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2441 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(" ".repeat(i));
            sb.append("*".repeat(N - i));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

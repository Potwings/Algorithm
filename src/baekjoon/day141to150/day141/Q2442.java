package baekjoon.day141to150.day141;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2442 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(" ".repeat(N - i - 1));
            sb.append("*".repeat(i * 2 + 1));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

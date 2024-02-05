package baekjoon.day101to200.day121to130.day127;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2440 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int j = N; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

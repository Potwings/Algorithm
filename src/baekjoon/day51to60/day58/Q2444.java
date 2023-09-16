package baekjoon.day51to60.day58;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2444 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(printStar(N, i));
        }

        for (int i = N - 2; i >= 0; i--) {
            sb.append(printStar(N, i));
        }

        System.out.println(sb.toString());
    }

    public static String printStar(int N, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = N - i; j > 1; j--) {
            sb.append(" ");
        }
        for (int k = 0; k < 2 * i + 1; k++) {
            sb.append("*");
        }

        sb.append("\n");

        return sb.toString();
    }
}

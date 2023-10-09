package baekjoon.day85;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2018 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 1;
        for (int i = 1; i < N; i++) {
            long sum = 0;
            for (int j = i; j < N; j++) {
                sum += j;
                if (sum == N) {
                    result++;
                } else if (sum > N) {
                    break;
                }
            }
        }
        System.out.println(result);
    }
}

package baekjoon.day81to90.day85;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2018 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 1; // N만 포함되는 경우
        long sum = 1;
        int start = 1;
        int end = 1;
        while (end < N) {
            if (sum > N) {
                sum -= start++;
            } else {
                if (sum == N) {
                    result++;
                }
                sum += ++end;
            }
        }
        System.out.println(result);
    }
}

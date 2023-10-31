package baekjoon.day107;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q4134 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            long num = Long.parseLong(br.readLine());
            while (!isPrime(num)) {
                num++;
            }
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }

    public static boolean isPrime(long num) {
        if (num == 0 || num == 1) {
            // 0,1은 소수가 아니다.
            return false;
        }

        if (num % 2 == 0) {
            // num이 짝수인 경우 2를 제외하고 소수가 아니다.
            return num == 2;
        }

        for (int j = 3; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                // 약수가 있을 경우 소수가 아니다.
                return false;
            }
        }

        return true;
    }
}

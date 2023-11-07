package baekjoon.day101to110.day107;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 개선 사항
 * 자릿수 추가 시 짝수가 추가되는 경우 홀수가 아니므로 짝수를 제외하고 추가 진행
 */
public class Q2023 {
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] primeNumArr = {2, 3, 5, 7}; // 한자리 수 중 소수

        sb = new StringBuilder();
        for (long num : primeNumArr) {
            int digit = 1;
            checkNextDigit(digit, num);
        }

        System.out.println(sb);
    }

    private static void checkNextDigit(int digit, long num) {

        if (digit == N) {
            // N자리수가 되었을 경우 검사 종료
            sb.append(num).append("\n");
            return;
        }
        digit++;
        for (int i = 1; i <= 9; i = i + 2) {
            // 2,4,6,8 짝수가 추가될 경우 소수가 아니므로 제외
            long checkNum = num * 10 + i;
            if (isPrime(checkNum)) {
                // 소수이면 다음 자리수 추가해서 진행
                checkNextDigit(digit, checkNum);
            }
        }
    }

    private static boolean isPrime(long num) {
        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

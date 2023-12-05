package baekjoon.day131to140.day139;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 개선 사항
 * 0일 경우 고려 안함
 */
public class Q10870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        int n1 = 0;
        int n2 = 1;
        for (int i = 1; i < N; i++) {
            int temp = n2;
            n2 = n1 + n2;
            n1 = temp;
        }

        System.out.println(n2);
    }
}

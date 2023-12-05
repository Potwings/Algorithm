package baekjoon.day131to140.day135;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2609 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        if (B > A) {
            int temp = A;
            A = B;
            B = temp;
        }

        int gcd = gcd(A, B);
        int lcm = A * B / gcd;

        StringBuilder sb = new StringBuilder();
        sb.append(gcd).append("\n").append(lcm);
        System.out.println(sb);
    }

    public static int gcd(int A, int B) {
        int remain = A % B;
        if (remain == 0) {
            return B;
        }
        return gcd(B, remain);
    }
}

package baekjoon.day121to130.day123;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q2338 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(A.add(B)).append("\n").append(A.subtract(B)).append("\n").append(A.multiply(B));
        System.out.println(sb);
    }
}

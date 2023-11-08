package baekjoon.day115;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Q1271 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger num1 = new BigInteger(st.nextToken());
        BigInteger num2 = new BigInteger(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(num1.divide(num2)).append("\n");
        sb.append(num1.mod(num2));

        System.out.println(sb);
    }
}

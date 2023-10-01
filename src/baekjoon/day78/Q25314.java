package baekjoon.day78;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q25314 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i += 4) {
            sb.append("long ");
        }
        sb.append("int");

        System.out.println(sb);
    }
}

package baekjoon.day77;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10807 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) == v) {
                result++;
            }
        }

        System.out.println(result);
    }
}

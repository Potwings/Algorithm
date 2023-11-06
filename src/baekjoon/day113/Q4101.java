package baekjoon.day113;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4101 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        String input = null;
        while (!(input = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(input);
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            sb.append(first > second ? "Yes" : "No").append("\n");
        }
        System.out.println(sb);
    }
}

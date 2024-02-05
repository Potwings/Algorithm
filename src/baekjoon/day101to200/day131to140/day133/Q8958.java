package baekjoon.day101to200.day131to140.day133;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q8958 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String input = null;
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            int result = 0;
            int before = 0;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'O') {
                    result += ++before;
                } else {
                    before = 0;
                }
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}

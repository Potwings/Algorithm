package baekjoon.day131to140.day131;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11721 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int inputLength = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 10; i < inputLength; i += 10) {
            sb.append(input, 0, 10).append("\n");
            input = input.substring(10);
        }
        sb.append(input);

        System.out.println(sb);
    }
}

package baekjoon.day1to100.day51to60.day59;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Stack<Integer> intStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            String result = "YES";
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == '(') {
                    intStack.push(1);
                } else {
                    if (intStack.empty()) {
                        // ')'이전에 '('가 없을 경우
                        result = "NO";
                        break;
                    }
                    intStack.pop();
                }
            }
            if (!intStack.empty()) {
                // '('가 남아있을 경우
                result = "NO";
            }

            intStack.clear(); // stack 초기화
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}

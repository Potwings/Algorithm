package baekjoon.day61to70.day64;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 개선 사항
 * 끝났음에도 닫히지 않은 괄호가 있을 경우 고려하지 않음
 *
 * 하 ㅋㅋ YES랑 NO 대소문자 때문에 틀림 진짜 ㅋㅋㅋㅋ
 * 제발 문제좀 잘 읽어주세요
 */
public class Q4949 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = null;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()).length() > 1) {

            // '(' 일경우 0, '[' 일 경우 1로 판단
            Stack<Integer> numStack = new Stack<>();
            String result = "yes";

            line:
            for (int i = 0; i < input.length(); i++) {

                char c = input.charAt(i);
                switch (c) {
                    case '(':
                        numStack.push(0);
                        break;
                    case '[':
                        numStack.push(1);
                        break;
                    case ')':
                        if (!numStack.isEmpty()) {
                            int num = numStack.pop();
                            if (num == 0) {
                                break;
                            }
                        }
                        result = "no";
                        break line;
                    case ']':
                        if (!numStack.isEmpty()) {
                            int num = numStack.pop();
                            if (num == 1) {
                                break;
                            }
                        }
                        result = "no";
                        break line;
                }
            }
            
            if(!numStack.isEmpty()){
                // 끝났음에도 닫히지 않은 괄호가 있을 경우
                result = "no";
            }
            
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}

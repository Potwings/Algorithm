package baekjoon.day101to200.day111to120.day116;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2744 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] charArr = input.toCharArray();

        StringBuilder sb = new StringBuilder();
        for(char c : charArr) {
            if(c >= 'a' && c <= 'z') {
                // 소문자일 경우 대문자로
                sb.append(Character.toUpperCase(c));
            } else {
                // 대문자일 경우 소문자로
                sb.append(Character.toLowerCase(c));
            }
        }

        System.out.println(sb);
    }
}

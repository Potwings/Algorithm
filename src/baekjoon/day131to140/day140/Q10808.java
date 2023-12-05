package baekjoon.day131to140.day140;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10808 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] resultArr = new int[26];
        for(int i = 0; i < input.length(); i++) {
            resultArr[input.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int result : resultArr) {
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }
}

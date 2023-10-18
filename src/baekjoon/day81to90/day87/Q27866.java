package baekjoon.day81to90.day87;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q27866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int i = Integer.parseInt(br.readLine());
        System.out.println(input.charAt(i - 1));
    }
}

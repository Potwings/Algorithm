package baekjoon.day101to200.day121to130.day122;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5522 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result += Integer.parseInt(br.readLine());
        }
        System.out.println(result);
    }
}

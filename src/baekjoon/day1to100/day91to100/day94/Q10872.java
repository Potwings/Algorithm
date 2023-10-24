package baekjoon.day1to100.day91to100.day94;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10872 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 1;
        for(int i = 2; i <= N; i++){
            result = result * i;
        }

        System.out.println(result);
    }
}

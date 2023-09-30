package baekjoon.day76;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11382 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long result = 0;
        for(int i = 0; i < 3; i++){
            result += Long.parseLong(st.nextToken());
        }
        System.out.println(result);
    }
}

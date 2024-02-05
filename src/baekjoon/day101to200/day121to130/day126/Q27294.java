package baekjoon.day101to200.day121to130.day126;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q27294 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int result = 280;
        if (T >= 12 && T <= 16 && S != 1) {
            result = 320;
        }

        System.out.println(result);
    }
}

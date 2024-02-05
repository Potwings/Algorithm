package baekjoon.day101to200.day121to130.day130;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4153 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 0) {
                break;
            }
            int[] sides = {a, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            Arrays.sort(sides);

            sb.append(Math.pow(sides[2], 2) == Math.pow(sides[0], 2) + Math.pow(sides[1], 2) ? "right" : "wrong").append("\n");
        }

        System.out.println(sb);
    }
}

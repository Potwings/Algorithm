package baekjoon.day1to100.day51to60.day57;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Q10811 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] baskets = IntStream.rangeClosed(1, N).toArray();
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            for (int l = 0; l < (j - i) / 2.0; l++) {
                int temp = baskets[j - l];
                baskets[j - l] = baskets[i + l];
                baskets[i + l] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int basket : baskets) {
            sb.append(basket).append(" ");
        }

        System.out.println(sb.toString());
    }
}

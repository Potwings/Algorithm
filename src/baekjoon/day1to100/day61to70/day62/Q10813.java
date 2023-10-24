package baekjoon.day1to100.day61to70.day62;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Q10813 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] balls = IntStream.rangeClosed(1, N).toArray();
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            int temp = balls[i];
            balls[i] = balls[j];
            balls[j] = temp;
        }

        StringJoiner sj = new StringJoiner(" ");
        for(int ball : balls) {
            sj.add(String.valueOf(ball));
        }

        System.out.println(sj);
    }
}

package baekjoon.day71;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10250 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            st.nextToken(); // W값은 계산에 필요 없다.
            int N = Integer.parseInt(st.nextToken());

            int roomNum = 0;
            if (N % H == 0) {
                roomNum = H * 100 + N / H;
            } else {
                roomNum = N % H * 100 + N / H + 1;
            }
            sb.append(roomNum).append("\n");
        }
        System.out.println(sb);
    }
}
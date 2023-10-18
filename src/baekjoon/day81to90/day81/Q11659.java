package baekjoon.day81to90.day81;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 애초에 숫자 i,j를 1부터 받으므로 합 배열에 값을 인덱스 1부터 시작하면 0일 경우는 0이므로 예외 처리를 할 필요가 없다.
 */
public class Q11659 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sumArr = new int[N + 1];
        st = new StringTokenizer(br.readLine()); // 합을 구하게 될 대상들
        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(sumArr[j] - sumArr[i - 1]).append("\n");
        }

        System.out.println(sb);
    }
}

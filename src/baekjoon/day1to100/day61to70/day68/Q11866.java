package baekjoon.day1to100.day61to70.day68;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 큐의 현재 상태를 유지한 상태에서 계속 제거 진행 제거된 값을 배열에 저장

/**
 * 개선 사항
 * 마지막 한번은 while loop 바깥에서 진행하여 이전 회차들과 다르게 문자열을 append할 수 있다.
 */
public class Q11866 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> numQueue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            numQueue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (numQueue.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                int num = numQueue.poll();
                numQueue.offer(num);
            }
            int removeNum = numQueue.poll();
            sb.append(removeNum);

            sb.append(", ");
        }
        sb.append(numQueue.poll());
        sb.append(">");
        System.out.println(sb);
    }
}
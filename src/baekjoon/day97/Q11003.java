package baekjoon.day97;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 덱에 인덱스와 값을 같이 저장한다.
 * 그 후 새로운 값들을 추가하며
 * 덱에서 인덱스가 초과되었을 경우, 숫자 값이 새로 추가된 값보다 클 경우 제거를 진행한다.
 */
public class Q11003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> numDeQueue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (!numDeQueue.isEmpty()) {
                if (numDeQueue.peekFirst().idx <= i - L) {
                    // 인덱스가 범위에서 초과되었을 경우 제거
                    numDeQueue.pollFirst();
                }
            }

            // 인덱스를 기반으로 제거하는 과정에서 numDequeue가 Empty 상태가 되었을 수도 있으므로 다시 확인
            while (!numDeQueue.isEmpty() && numDeQueue.peekLast().num >= num) {
                // 새로 추가되는 값보다 크거나 같을 경우 제거
                numDeQueue.pollLast();
            }
            numDeQueue.offer(new Node(i, num));
            sb.append(numDeQueue.peekFirst().num).append(" ");
        }
        System.out.println(sb);
    }

    public static class Node {
        int idx;

        int num;

        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}

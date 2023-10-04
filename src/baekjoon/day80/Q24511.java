package baekjoon.day80;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 처음에 받은 원소는 미자막에 입력받은 값을 반환해야하고 배열 C를 통해 입력받은 값은 먼저 입력받은 값부터 반환해야하므로 Dequeue로 처리한다.
/**
 * 자료구조가 stack일 경우 입력받은 값을 반환하므로 queue인 경우만 numDeQueue의 First로 담아준 후
 * 배열 C를 통해 입력받은 값들을 numDeQueue의 First에 넣어준 후 Last에서 가져온 값을 반환하면 된다.
 */
public class Q24511 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N값 입력
        Deque<Integer> numDeQueue = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine()); // queue stack 여부 입력
        StringTokenizer eleSt = new StringTokenizer(br.readLine()); // queuestack의 원소값 입력
        for (int i = 0; i < N; i++) {
            int structure = Integer.parseInt(st.nextToken()); // 0 - queue, 1 - stack
            int element = Integer.parseInt(eleSt.nextToken());

            if(structure == 0) {
                numDeQueue.offerLast(element);
            }
        }

        int M = Integer.parseInt(br.readLine()); // 입력받을 원소 배열 C의 길이 입력
        st = new StringTokenizer(br.readLine()); // C의 내용 입력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            numDeQueue.offerFirst(Integer.parseInt(st.nextToken()));
            sb.append(numDeQueue.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}

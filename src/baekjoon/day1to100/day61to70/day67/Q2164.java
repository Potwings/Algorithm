package baekjoon.day1to100.day61to70.day67;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

// 첫번째 카드 버리고 그 다음 카드 아래로 넘기고 -> Queue에서 poll 진행 후 저장하지 않고 그 다음 수는 poll 진행 후 offer 진행한다.
public class Q2164 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> cardQueue = new LinkedList<>();
        IntStream.rangeClosed(1, N).forEach(cardQueue::offer);

        while (cardQueue.size() > 1) {
            cardQueue.poll(); // 첫번쨰 카드 버림
            int second = cardQueue.poll();
            cardQueue.offer(second); // 두번째 카드 맨 아래에 추가
        }

        System.out.println(cardQueue.poll());
    }
}

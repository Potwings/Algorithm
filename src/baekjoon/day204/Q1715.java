package baekjoon.day204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 개선 사항
 * 우선순위 큐의 요소 개수가 2개 이상이여야 두 수를 비교할 수 있다.
 */
public class Q1715 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pQueue = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      pQueue.offer(Integer.parseInt(br.readLine()));
    }

    // 가장 작은 카드 묶음부터 비교해야 비교의 최소값을 구할 수 있다.
    long result = 0;
    while (pQueue.size() >= 2) {
      int first = pQueue.poll();
      int second = pQueue.poll();

      int sum = first + second;
      result += sum;
      pQueue.offer(sum);
    }

    System.out.println(result);
  }
}

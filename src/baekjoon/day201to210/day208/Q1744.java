package baekjoon.day201to210.day208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 개선 사항
 * 묶었을 때 오히려 작아지는 경우(1일 경우)를 고려하지 않음
 */
public class Q1744 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    // 음수 큐 - 음수는 작은 수끼리 묶어주어야 한다.
    PriorityQueue<Integer> negPQueue = new PriorityQueue<>();
    // 양수 큐 - 양수는 큰 수끼리 묶어주어야 한다.
    PriorityQueue<Integer> posPQueue = new PriorityQueue<>(Collections.reverseOrder());
    // 0의 존재 여부
    boolean zeroExist = false;

    int sum = 0;
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num < 0) {
        negPQueue.offer(num);
      } else if (num == 1) {
        sum++;
      } else if (num > 0) {
        posPQueue.offer(num);
      } else {
        zeroExist = true;
      }
    }

    /*
     * 음수가 홀수개인 경우 -> 가장 큰 홀수와 0을 묶어준다.
     * 음수가 짝수개인 경우 -> 0을 묶는데 사용하지 않는다.
     */
    while (posPQueue.size() >= 2) {
      // 큐에 최소 두개 이상 존재할 경우 진행
      int tie = posPQueue.poll() * posPQueue.poll();
      sum += tie;
    }

    if (!posPQueue.isEmpty()) {
      // 남아있을 경우 묶지 않고 합해준다.
      sum += posPQueue.poll();
    }

    while (negPQueue.size() >= 2) {
      // 큐에 최소 두개 이상 존재할 경우 진행
      int tie = negPQueue.poll() * negPQueue.poll();
      sum += tie;
    }

    if (!negPQueue.isEmpty()) {
      // 하나 남아있고 0이 있을 경우 0과 묶어준다.
      if (!zeroExist) {
        sum += negPQueue.poll();
      }
    }
    System.out.println(sum);
  }
}

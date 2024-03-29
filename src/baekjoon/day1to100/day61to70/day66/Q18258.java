package baekjoon.day1to100.day61to70.day66;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제
 * 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 * 명령은 총 여섯 가지이다.
 * push X: 정수 X를 큐에 넣는 연산이다. -> offer
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다. -> poll
 * size: 큐에 들어있는 정수의 개수를 출력한다. -> size
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다. -> isEmpty
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다. -> peek
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다. -> 별도로 메모리에 저장
 * 입력
 * 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 2,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 * <p>
 * 출력
 * 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 */

/**
 * 개선 사항
 * Queue가 중간에 다 비워졌을 경우 고려 안함
 */
public class Q18258 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> integerQueue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int back = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push" :
                    Integer num = Integer.parseInt(st.nextToken());
                    integerQueue.offer(num);
                    back = num;
                    break;
                case "pop":
                    num = integerQueue.poll();
                    sb.append(num != null ? num : -1).append("\n");
                    break;
                case "size":
                    sb.append(integerQueue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(integerQueue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front" :
                    num = integerQueue.peek();
                    sb.append(num != null ? num : -1).append("\n");
                    break;
                case "back":
                    // 중간에 다 비워졌을 경우 고려
                    back = integerQueue.isEmpty() ? -1 : back;
                    sb.append(back).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
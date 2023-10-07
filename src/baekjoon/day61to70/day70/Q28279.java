package baekjoon.day61to70.day70;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 정수를 저장하는 덱을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 * <p>
 * 명령은 총 여덟 가지이다.
 * <p>
 * 1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000) - offerFirst()
 * 2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000) - offerLast()
 * 3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다. - pollFirst() if(null) return -1
 * 4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다. - pollLast() if(null) return -1
 * 5: 덱에 들어있는 정수의 개수를 출력한다. - size()
 * 6: 덱이 비어있으면 1, 아니면 0을 출력한다. - isEmpty()
 * 7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다. - peekFirst() if(null) return -1
 * 8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다. - peekLast() if(null) return -1
 */
public class Q28279 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> numDeque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int command = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1:
                    numDeque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    numDeque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case 5:
                    sb.append(numDeque.size()).append("\n");
                    break;
                case 6:
                    sb.append(numDeque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 3:
                    Integer num = numDeque.pollFirst();
                    sb.append(num == null ? -1 : num).append("\n");
                    break;
                case 4:
                    num = numDeque.pollLast();
                    sb.append(num == null ? -1 : num).append("\n");
                    break;
                case 7:
                    num = numDeque.peekFirst();
                    sb.append(num == null ? -1 : num).append("\n");
                    break;
                case 8:
                    num = numDeque.peekLast();
                    sb.append(num == null ? -1 : num).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}

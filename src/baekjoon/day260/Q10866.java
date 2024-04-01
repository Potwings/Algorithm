package baekjoon.day260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q10866 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    Deque<Integer> numDeque = new ArrayDeque<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      switch (st.nextToken()) {
        case "push_front":
          int num = Integer.parseInt(st.nextToken());
          numDeque.offerFirst(num);
          break;
        case "push_back":
          num = Integer.parseInt(st.nextToken());
          numDeque.offer(num);
          break;
        case "pop_front":
          sb.append(numDeque.isEmpty() ? -1 : numDeque.poll()).append("\n");
          break;
        case "pop_back":
          sb.append(numDeque.isEmpty() ? -1 : numDeque.pollLast()).append("\n");
          break;
        case "size":
          sb.append(numDeque.size()).append("\n");
          break;
        case "empty":
          sb.append(numDeque.isEmpty() ? 1 : 0).append("\n");
          break;
        case "front":
          sb.append(numDeque.isEmpty() ? -1 : numDeque.peek()).append("\n");
          break;
        case "back":
          sb.append(numDeque.isEmpty() ? -1 : numDeque.peekLast()).append("\n");
          break;
      }
    }
    System.out.println(sb);
  }

}

package baekjoon.day148;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q10845 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Deque<Integer> deque = new ArrayDeque<>();
    StringTokenizer st = null;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      switch (st.nextToken()) {
        case "push":
          deque.offer(Integer.parseInt(st.nextToken()));
          break;
        case "pop":
          int pop = -1;
          if (!deque.isEmpty()) {
            pop = deque.pop();
          }
          sb.append(pop).append("\n");
          break;
        case "size":
          sb.append(deque.size()).append("\n");
          break;
        case "empty":
          sb.append(deque.isEmpty()?1 : 0).append("\n");
          break;
        case "front":
          int front = -1;
          if (!deque.isEmpty()) {
            front = deque.peekFirst();
          }
          sb.append(front).append("\n");
          break;
        case "back":
          int back = -1;
          if (!deque.isEmpty()) {
            back = deque.peekLast();
          }
          sb.append(back).append("\n");
          break;
      }
    }
    System.out.println(sb);
  }

}

package baekjoon.day101to200.day141to150.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q10828 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      switch (st.nextToken()) {
        case "push":
          stack.push(Integer.parseInt(st.nextToken()));
          break;
        case "pop":
          int pop = -1;
          if (!stack.isEmpty()) {
            pop = stack.pop();
          }
          sb.append(pop).append("\n");
          break;
        case "size":
          sb.append(stack.size()).append("\n");
          break;
        case "empty":
          sb.append(stack.isEmpty() ? 1 : 0).append("\n");
          break;
        case "top":
          int top = -1;
          if (!stack.isEmpty()) {
            top = stack.peek();
          }
          sb.append(top).append("\n");
          break;
      }
    }

    System.out.println(sb);
  }

}

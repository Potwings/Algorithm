package baekjoon.day261;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q11656 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    PriorityQueue<String> pQueue = new PriorityQueue<>();
    for (int i = 0; i < input.length(); i++) {
      pQueue.offer(input.substring(i));
    }
    StringBuilder sb = new StringBuilder();
    while (!pQueue.isEmpty()) {
      sb.append(pQueue.poll()).append("\n");
    }
    System.out.println(sb);
  }
}

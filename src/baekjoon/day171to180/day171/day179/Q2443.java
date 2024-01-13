package baekjoon.day171to180.day171.day179;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2443 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = N; i >= 1; i--) {
      sb.append(" ".repeat(N - i)).append("*".repeat(2 * (i - 1) + 1)).append("\n");
    }
    System.out.println(sb);
  }
}

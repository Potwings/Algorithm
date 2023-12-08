package baekjoon.day145;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2446 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = N; i > 0; i--) {
      sb.append(" ".repeat(N - i));
      sb.append("*".repeat(2 * i - 1));
      sb.append("\n");
    }

    for (int i = 2; i <= N; i++) {
      sb.append(" ".repeat(N - i));
      sb.append("*".repeat(2 * i - 1));
      sb.append("\n");
    }
    System.out.print(sb);
  }
}

package baekjoon.day191;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10992 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    sb.append(" ".repeat(N - 1)).append("*").append("\n");

    for (int i = 2; i <= N - 1; i++) {
      sb.append(" ".repeat(N - i)).append("*");
      sb.append(" ".repeat( 2 * (i - 2) + 1));
      sb.append("*").append("\n");
    }

    if(N > 1) {
      sb.append("*".repeat(2 * (N - 1) + 1));
    }
    System.out.println(sb);
  }

}

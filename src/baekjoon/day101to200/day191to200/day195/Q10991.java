package baekjoon.day101to200.day191to200.day195;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10991 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(" ".repeat(N - i - 1)).append("*");
      sb.append(" *".repeat(i)).append("\n");
    }
    System.out.println(sb);
  }
}

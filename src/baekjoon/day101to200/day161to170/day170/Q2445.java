package baekjoon.day101to200.day161to170.day170;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2445 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sb.append("*".repeat(i)).append(" ".repeat((N - i) * 2)).append("*".repeat(i)).append("\n");
    }
    for (int i = N - 1; i >= 1; i--) {
      sb.append("*".repeat(i)).append(" ".repeat((N - i) * 2)).append("*".repeat(i)).append("\n");
    }
    System.out.println(sb);
  }

}

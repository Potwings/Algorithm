package baekjoon.day246;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9095 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] D = new int[11];
    D[1] = 1;
    D[2] = 2;
    D[3] = 4;
    for (int i = 4; i <= 10; i++) {
      D[i] = D[i - 3] + D[i - 2] + D[i - 1];
    }

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      sb.append(D[Integer.parseInt(br.readLine())]).append("\n");
    }
    System.out.println(sb);
  }

}

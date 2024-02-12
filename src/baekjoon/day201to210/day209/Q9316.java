package baekjoon.day201to210.day209;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9316 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int i = 1; i <= N; i++) {
      sb.append("Hello World, Judge ").append(i).append("!").append("\n");
    }

    System.out.println(sb);
  }
}

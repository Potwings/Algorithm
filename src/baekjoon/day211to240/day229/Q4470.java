package baekjoon.day211to240.day229;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q4470 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int i = 1; i <= N; i++) {
      sb.append(i).append(". ");
      sb.append(br.readLine()).append("\n");
    }
    System.out.println(sb);
  }
}

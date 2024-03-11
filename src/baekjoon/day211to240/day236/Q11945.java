package baekjoon.day211to240.day236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11945 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    StringBuilder sb = null;
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb = new StringBuilder(br.readLine());
      result.append(sb.reverse()).append("\n");
    }
    System.out.println(result);
  }
}

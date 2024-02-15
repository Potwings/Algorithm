package baekjoon.day214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5717 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    String input;
    StringBuilder sb = new StringBuilder();
    while (!(input = br.readLine()).startsWith("0")) {
      st = new StringTokenizer(input);
      sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
    }
    System.out.println(sb);
  }

}

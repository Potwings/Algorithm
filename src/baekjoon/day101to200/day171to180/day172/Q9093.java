package baekjoon.day101to200.day171to180.day172;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9093 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      while(st.hasMoreTokens()) {
        String word = st.nextToken();
        for(int j = word.length() - 1; j >= 0; j--) {
          char c = word.charAt(j);
          sb.append(c);
        }
        sb.append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}

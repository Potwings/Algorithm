package baekjoon.day171to180.day171.day177;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4796 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    String input;
    StringBuilder sb = new StringBuilder();
    int caseNum = 0;
    while (!(input = br.readLine()).equals("0 0 0")) {
      st = new StringTokenizer(input);

      int L = Integer.parseInt(st.nextToken());
      int P = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());
      int day = (V / P) * L;
      day += Math.min((V % P), L);

      sb.append("Case ").append(++caseNum).append(": ").append(day).append("\n");
    }
    System.out.println(sb);
  }

}

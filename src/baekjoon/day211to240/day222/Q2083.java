package baekjoon.day211to240.day222;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2083 {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    while (!(input = br.readLine()).startsWith("#")) {
      st = new StringTokenizer(input);
      String name = st.nextToken();
      int age = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      sb.append(name).append(" ");
      if(age > 17 || weight >= 80) {
        sb.append("Senior");
      } else {
        sb.append("Junior");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }


}

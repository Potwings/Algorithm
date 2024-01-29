package baekjoon.day197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10797 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int day = Integer.parseInt(br.readLine());
    int result = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      if (Integer.parseInt(st.nextToken()) == day) {
        result++;
      }
    }
    System.out.println(result);
  }
}

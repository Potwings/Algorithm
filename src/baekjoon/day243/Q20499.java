package baekjoon.day243;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20499 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    StringTokenizer st = new StringTokenizer(input, "/");
    int[] kda = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
        Integer.parseInt(st.nextToken())};
    if (kda[1] == 0 || kda[0] + kda[2] < kda[1]) {
      System.out.println("hasu");
    } else {
      System.out.println("gosu");
    }
  }
}

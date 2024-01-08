package baekjoon.day176;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10824 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String ab = st.nextToken() + st.nextToken();
    String cd = st.nextToken() + st.nextToken();
    System.out.println(Integer.parseInt(ab) + Integer.parseInt(cd));
  }
}

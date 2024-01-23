package baekjoon.day181to190.day181;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2455 {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int person = 0;
    int max = 0;
    StringTokenizer st;
    for(int i = 0; i < 4; i++) {
      st = new StringTokenizer(br.readLine());
      int off = Integer.parseInt(st.nextToken());
      int ride = Integer.parseInt(st.nextToken());
      person = person - off + ride;
      max = Math.max(person,max);
    }

    System.out.println(max);
  }

}

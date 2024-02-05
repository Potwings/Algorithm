package baekjoon.day101to200.day161to170.day161;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3046 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int R1 = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    System.out.println(S * 2 - R1);
  }

}

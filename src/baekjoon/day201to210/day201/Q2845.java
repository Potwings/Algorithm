package baekjoon.day201to210.day201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2845 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int total = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()); // 상근 총 인원 수
    st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 5; i++) {
      sb.append(Integer.parseInt(st.nextToken()) - total).append(" "); // 각 신문 인원 수와의 차이
    }
    System.out.println(sb);
  }
}

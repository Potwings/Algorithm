package baekjoon.day161to170.day162;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 불필요한 temp변수 제거
 */
public class Q2530 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(br.readLine());
    s += D;
    m += s / 60;
    s %= 60;
    h += m / 60;
    m %= 60;
    h %= 24;
    StringBuilder sb = new StringBuilder();
    sb.append(h).append(" ").append(m).append(" ").append(s);
    System.out.println(sb);
  }
}

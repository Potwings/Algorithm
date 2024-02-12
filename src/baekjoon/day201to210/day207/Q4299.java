package baekjoon.day201to210.day207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4299 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int sum = Integer.parseInt(st.nextToken());
    int diff = Integer.parseInt(st.nextToken());

    double win = sum / 2.0 + diff / 2.0;
    double lose = sum / 2.0 - diff / 2.0;
    if (lose < 0 || win % 1 > 0) {
      // 패배 팀의 점수가 0보다 작거나 점수가 소수점일 경우 불가능한 결과이다.
      System.out.println(-1);
      return;
    }
    System.out.println((int) win);
    System.out.println((int) lose);
  }
}

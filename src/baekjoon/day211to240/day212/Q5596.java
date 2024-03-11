package baekjoon.day211to240.day212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * StringTokenizer 두개를 동시에 반복문 진행하여
 * 반복 횟수를 줄여준다.
 */
public class Q5596 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    int sum1 = 0;
    int sum2 = 0;
      for (int j = 0; j < 4; j++) {
        sum1 += Integer.parseInt(st1.nextToken());
        sum2 += Integer.parseInt(st2.nextToken());
      }

    System.out.println(Math.max(sum1, sum2));
  }
}

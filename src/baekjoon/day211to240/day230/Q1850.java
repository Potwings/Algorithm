package baekjoon.day211to240.day230;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * for문 조건안에서 gcd 메소드를 호출하면
 * 불필요하게 반복 진행 시마다 해당 메소드 호출 발생
 */
public class Q1850 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    StringBuilder sb = new StringBuilder();
    long gcd = gcd(A, B);
    for (long i = 0; i < gcd; i++) {
      sb.append("1");
    }
    System.out.println(sb);
  }

  public static long gcd(long A, long B) {

    long r = A % B;
    if (r == 0) {
      return B;
    }

    return gcd(B, r);
  }

}
package baekjoon.day180;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 두 수의 대소관계가 역전되는 경우, 두 수가 같은 경우 고려 안함
 */
public class Q10093 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    if (A > B) {
      long temp = B;
      B = A;
      A = temp;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(B == A ? 0 : B - A - 1).append("\n");
    for (long i = A + 1; i < B; i++) {
      sb.append(i).append(" ");
    }
    System.out.println(sb);
  }
}

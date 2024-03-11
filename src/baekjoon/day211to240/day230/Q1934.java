package baekjoon.day211to240.day230;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1934 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      if (B > A) {
        int temp = A;
        A = B;
        B = temp;
      }
      int gcd = gcd(A, B);
      sb.append(A * B / gcd).append("\n");
    }

    System.out.println(sb);
  }

  public static int gcd(int A, int B) {
    int mod = A % B;
    if (mod == 0) {
      return B;
    }
    return gcd(B, mod);
  }
}

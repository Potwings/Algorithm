package baekjoon.day241to268.day263;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9613 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int[] numArr;
    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      long result = 0;
      numArr = new int[N];
      for (int j = 0; j < N; j++) {
        numArr[j] = Integer.parseInt(st.nextToken());
      }
      for (int j = 0; j < N; j++) {
        for (int k = j + 1; k < N; k++) {
          result += gcd(numArr[j], numArr[k]);
        }
      }
      sb.append(result).append("\n");
    }
    System.out.println(sb);
  }

  public static int gcd(int a, int b) {

    int r = a % b;
    if (r == 0) {
      return b;
    }

    return gcd(b, r);
  }
}

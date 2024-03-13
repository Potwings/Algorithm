package baekjoon.day241;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11726 {

  static long[] D;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    D = new long[N + 1];
    D[0] = 1;
    D[1] = 1;
    // BOTTOM - UP
    for (int i = 2; i <= N; i++) {
      D[i] = (D[i - 1] + D[i - 2]) % 10007;
    }
    System.out.println(D[N]);
    // System.out.println(getFiboNum(N));
  }

  // TOP - DOWN
  public static long getFiboNum(int num) {
    if (D[num] == 0) {
      D[num] = getFiboNum(num - 1) + getFiboNum(num - 2) % 10007;
    }
    return D[num];
  }

}

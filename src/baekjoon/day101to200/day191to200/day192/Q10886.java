package baekjoon.day101to200.day191to200.day192;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10886 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int no = 0;
    int yes = 0;
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num == 1) {
        yes++;
      } else {
        no++;
      }
    }

    if (yes > no) {
      System.out.println("Junhee is cute!");
    } else {
      System.out.println("Junhee is not cute!");
    }
  }
}

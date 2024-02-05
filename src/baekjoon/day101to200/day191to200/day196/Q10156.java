package baekjoon.day101to200.day191to200.day196;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10156 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken()); // 과자 한개의 가격 K
    int N = Integer.parseInt(st.nextToken()); // 과자의 개수 C
    int M = Integer.parseInt(st.nextToken()); // 가진 돈 M

    System.out.println(Math.max(K * N - M, 0)); // 가진돈이 더 많을 경우 0 출력
  }

}

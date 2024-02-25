package baekjoon.day224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13909 {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int I = Integer.parseInt(st.nextToken());

    /*
     * 최소값을 구하는데 I는 무조건 올림처리하므로
     * I를 1빼주고 계산 후 결과값에서 1을 추가해준다.
     */
    System.out.println(A * (I - 1) + 1);
  }

}

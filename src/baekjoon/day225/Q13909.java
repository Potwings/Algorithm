package baekjoon.day225;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q13909 {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    /*
     * 창문이 열려있으려면 약수가 홀수개여야 한다.
     * 약수가 홀수개인 경우는 제곱수인 경우이다.
     * (제곱수가 아닌 경우 하나의 약수는 자신과 다른 수를 곱해야 현재의 수가 되므로 약수는 항상 짝수개이다)
     */
    System.out.println((int)Math.sqrt(N));
  }
}

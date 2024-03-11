package baekjoon.day211to240.day226;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q24723 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    // 층이 추가될 때마다 마지막 층에서 선택할 수 있는 경우가 2가지씩 생기는 것이므로 2^N이 정답이다.
    System.out.println((int) Math.pow(2, N));
  }

}

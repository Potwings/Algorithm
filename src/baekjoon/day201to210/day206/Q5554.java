package baekjoon.day201to210.day206;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5554 {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sum = 0;
    for(int i = 0; i < 4; i++) {
      sum += Integer.parseInt(br.readLine());
    }
    System.out.println(sum / 60);
    System.out.println(sum % 60);
  }

}

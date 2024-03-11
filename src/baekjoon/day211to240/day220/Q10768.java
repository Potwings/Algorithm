package baekjoon.day211to240.day220;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10768 {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int month = Integer.parseInt(br.readLine());
    int day = Integer.parseInt(br.readLine());
    int date = month * 100 + day;
    if(date > 218) {
      System.out.println("After");
    } else if (date < 218) {
      System.out.println("Before");
    } else {
      System.out.println("Special");
    }
  }
}

package baekjoon.day235;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q4999 {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String jaehwan = br.readLine();
    String doctor = br.readLine();
    System.out.println(jaehwan.length() >= doctor.length() ? "go" : "no");
  }
}

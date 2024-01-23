package baekjoon.day171to180.day174;

import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;

public class Q2576 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sum = 0;
    int min = 100;
    for (int i = 0; i < 7; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num % 2 > 0) {
        sum += num;
        if (num < min) {
          min = num;
        }
      }
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    if(sum > 0){
      bw.write(String.valueOf(sum));
      bw.write("\n");
      bw.write(String.valueOf(min));
    } else {
      bw.write("-1");
    }
    bw.flush();
    bw.close();
  }

}

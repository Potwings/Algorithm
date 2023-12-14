package baekjoon.day141to150.day146;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2920 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputArr = br.readLine().split(" ");
    String[] ascendingArr = {"1", "2", "3", "4", "5", "6", "7", "8"};
    String[] descendingArr = {"8", "7", "6", "5", "4", "3", "2", "1"};
    String result = "mixed";
    if (Arrays.equals(inputArr, ascendingArr)) {
      result = "ascending";
    } else if (Arrays.equals(inputArr, descendingArr)) {
      result = "descending";
    }

    System.out.println(result);
  }
}

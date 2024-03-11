package baekjoon.day211to240.day227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11943 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] nums = new int[4];
    StringTokenizer st;
    for (int i = 0; i <= 2; i+= 2) {
      st = new StringTokenizer(br.readLine());
      nums[i] = Integer.parseInt(st.nextToken());
      nums[i + 1] = Integer.parseInt(st.nextToken());
    }

    System.out.println(Math.min(nums[0] + nums[3], nums[1] + nums[2]));
  }
}

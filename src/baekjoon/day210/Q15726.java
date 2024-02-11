package baekjoon.day210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 소수점 발생할 경우 고려하지 않음
 * int -> double로 수정
 */
public class Q15726 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    double[] nums = new double[3];
    for (int i = 0; i < 3; i++) {
      nums[i] = Double.parseDouble(st.nextToken());
    }

    System.out.println((int) Math.max(nums[0] * nums[1] / nums[2], nums[0] / nums[1] * nums[2]));
  }
}

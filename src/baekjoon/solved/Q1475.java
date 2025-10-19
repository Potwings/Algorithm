package baekjoon.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Problem
 * 0 ~ 9까지 있는 플라스틱 숫자 세트 존재
 * 몇 세트가 있어야 원하는 숫자를 만들 수 있는가?
 * 단 6과 9는 서로 대체 가능
 */
public class Q1475 {

  /*
   * solve
   * 숫자 종류별 개수 확인
   * 6과 9의 경우 하나의 종류로 분류 & 세트 추가 시 2개 증가
   */

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] inputArr = br.readLine().toCharArray();
    int[] countArr = new int[9];
    for (char c : inputArr) {
      int num = c - '0';
      if (num == 9) {
        // 9일 경우 6과 통합해서 처리
        num = 6;
      }
      countArr[num]++;
    }

    countArr[6]++; // 홀수일 경우 세트가 더 필요한 것 이므로 +1
    countArr[6] /= 2; // 한 세트 당 두개씩 제공되므로 2로 나눔
    int needCount = Arrays.stream(countArr).max().getAsInt();

    System.out.println(needCount);
  }
}

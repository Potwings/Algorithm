package baekjoon.day201to210.day202;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5532 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    /*
     * L, A, B, C, D 순으로 저장
     * L - 방학 일 수, A - 국어 총 숙제, B - 수학 총 숙제
     * C - 하루 국어 최대, D - 하루 수학 최대
     */
    int[] varArr = new int[5];
    for (int i = 0; i < 5; i++) {
      varArr[i] = Integer.parseInt(br.readLine());
    }

    // 두 숙제를 모두 완료하기까지 소요되는 일자
    double maxHomeworkDay = Math.max((double) varArr[1] / varArr[3],
        (double) varArr[2] / varArr[4]);

    System.out.println(varArr[0] - (int) Math.ceil(maxHomeworkDay));
  }
}

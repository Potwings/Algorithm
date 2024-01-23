package baekjoon.day181to190.day185;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1924 {

  static final int[] monthArr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 월별 마지막일
  static final String[] dayArr = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int month = Integer.parseInt(st.nextToken());
    int day = Integer.parseInt(st.nextToken());

    int dayCount = 0;
    for (int i = 0; i < month - 1; i++) {
      dayCount += monthArr[i];// 해당 월까지의 지난 일자 계산
    }

    dayCount += day - 1; // 해당 일까지의 지난 일자 계산

    System.out.println(dayArr[dayCount % 7]); // 7로 나눈 나머지에 따라 요일 확인
  }
}

package baekjoon.day101to200.day171to180.day171;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2343 {

  // 클래스 변수
  // 강의 길이 배열 선언
  static int[] lectureArr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 총 강의의 개수 변수 선언
    int N = Integer.parseInt(st.nextToken());
    // 블루레이 개수 변수 선언
    int M = Integer.parseInt(st.nextToken());

    // 강의 길이 최대값 선언(블루레이 크기 최소값)(long)
    long min = 0;
    // 강의 길이의 합 선언(블루레이 크기 최대값)(long);
    long max = 0;
    lectureArr = new int[N];
    st = new StringTokenizer(br.readLine());
    // 강의 최대값 확인하며 길이, 합 저장
    for (int i = 0; i < N; i++) {
      int lecture = Integer.parseInt(st.nextToken());
      lectureArr[i] = lecture;
      if (lecture > min) {
        min = lecture;
      }
      max += lecture;
    }

    // 블루레이 길이에 따른 이분탐색 시작
    while (min <= max) {
      long now = (min + max) / 2;
      int count = getLectureCount(now);
      if (count <= M) {
        // 강의 개수가 목표한 개수보다 적을 경우 -> 블루레이의 크기를 줄인다.
        // 최소값을 구하고 있으므로 같을 경우에도 크기를 줄인다.
        max = now - 1;
      } else {
        // 강의 개수가 목표한 개수보다 많을 경우 -> 블루레이의 크기를 늘린다.
        min = now + 1;
      }
    }
    System.out.println(min);
  }


  // 블루레이 길이에 따른 강의 개수 확인 메소드 (param - long 블루레이 크기, return - int 강의 개수)
  public static int getLectureCount(long size) {
    // 강의 수 count 선언 (1부터 시작)
    int count = 1;
    // 임시 합 선언
    long temp = 0;
    // for loop 진행하며 강의 길이 합 계산
    for (int lecture : lectureArr) {
      // 임시 합이 블루레이 크기를 넘어갔을 경우 count++ & 임시 합 = 해당 강의의 길이;
      temp += lecture;
      if (temp > size) {
        temp = lecture;
        count++;
      }
    }

    return count; // count 반환
  }

}

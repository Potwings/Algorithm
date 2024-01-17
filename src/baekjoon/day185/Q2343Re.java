package baekjoon.day185;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * lower bound를 활용한 재풀이
 */
public class Q2343Re {

  static int[] lectureArr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 강의의 수
    long M = Integer.parseInt(st.nextToken()); // 블루레이의 수
    lectureArr = new int[N]; // 강의 길이 배열
    st = new StringTokenizer(br.readLine());
    int max = 0;
    long sum = 0;
    for (int i = 0; i < N; i++) {
      int lecture = Integer.parseInt(st.nextToken());
      lectureArr[i] = lecture;
      sum += lecture;
      if (lecture > max) {
        max = lecture;
      }
    }

    long start = max; // 블루레이는 최소 모든 강의를 담을 수는 있어야 한다.
    long end = sum; // 최대는 모든 강의를 하나의 블루레이에 담는 것이다.
    while (start < end) {
      long now = (start + end) / 2;
      long nowCount = getCount(now); // 현재 블루레이 길이에서의 강의 수 확인

      /*
       * 강의의 수가 목표보다 많으면 -> 블루레이 길이 늘려야 함
       * 강의의 수가 목표보다 적으면 -> 블루레이 길이 줄일 수 있음
       *
       * 블루레이의 길이 중 최소를 구해야 하므로 개수가 충족되는 lower bound를 확인해야함
       */

      if(nowCount > M) {
        // 강의의 개수가 목표보다 많을 경우
        start = now + 1; // 블루레이 길이 늘려준다.
      } else {
        // 강의의 개수가 목표보다 적거나 같을 경우
        end = now; // 블루레이의 길이를 최소로 잡기 위해 줄여준다.
      }

    }
    System.out.println(end); // lower bound에서는 end값이 결과 값이 된다.
  }

  public static long getCount(long length) {
    long count = 1;
    int temp = 0;
    for (int lecture : lectureArr) {
      temp += lecture;
      if(temp > length) {
        temp = lecture;
        count++;
      }
    }
    return count;
  }
}

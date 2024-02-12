package baekjoon.day211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 하루(24시간) 기준이 아니네...
 * 시작하자마자 끝나는 경우 고려 안함
 * 시작하자마자 끝나는 경우가 회의 도중에 있는 경우 고려 안함
 * 회의 시작 시간이 현재 회의 종료 시간 이후인 것만 진행하도록 수정
 * 시작하자마자 끝나는 회의가 있는 경우 우선 진행할 수 있도록 수정
 */
public class Q1931 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Meeting[] meetingArr = new Meeting[N];
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      meetingArr[i] = new Meeting(start, end);
    }

    // 끝나는 시간값 기준 정렬
    Arrays.sort(meetingArr);

    int count = 0;
    int now = 0;
    for (Meeting meeting : meetingArr) {
      if (meeting.start >= now) {
        now = meeting.end;
        count++;
      }
    }
    System.out.println(count);
  }

  public static class Meeting implements Comparable<Meeting> {

    int start;
    int end;

    public Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
      if (this.end == o.end) {
        return this.start - o.start;
      }
      return this.end - o.end;
    }
  }
}

package baekjoon.day241to268.day250;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 우선 순위 큐가 더 빨라 List에서 우선 순위 큐로 변경
 */
public class Q10825 {

  public static class Student implements Comparable<Student> {

    String name;
    int korea;
    int english;
    int math;

    public Student(String name, int korea, int english, int math) {
      this.name = name;
      this.korea = korea;
      this.english = english;
      this.math = math;
    }

    @Override
    public int compareTo(Student s) {
      if (korea != s.korea) {
        return s.korea - this.korea;
      }

      if (english != s.english) {
        return this.english - s.english;
      }

      if (math != s.math) {
        return s.math - math;
      }

      return name.compareTo(s.name);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Student> pStudnetQueue = new PriorityQueue<>();
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      pStudnetQueue.offer(new Student(st.nextToken(), Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    StringBuilder sb = new StringBuilder();
    while (!pStudnetQueue.isEmpty()) {
      sb.append(pStudnetQueue.poll().name).append("\n");
    }
    System.out.println(sb);
  }
}

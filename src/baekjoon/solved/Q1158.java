package baekjoon.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Q1158 {

  // List 사용
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 총 인원 수
    int K = Integer.parseInt(st.nextToken()); // K번째 사람 제거

    List<Integer> numList = new LinkedList<>();
    IntStream.rangeClosed(1, N).forEach(numList::add);

    int idx = 0;
    StringBuilder sb = new StringBuilder();
    sb.append("<");
    while (!numList.isEmpty()) {
      idx += K - 1;
      idx %= numList.size();
      sb.append(numList.remove(idx));
      if (!numList.isEmpty()) {
        sb.append(", ");
      }
    }

    sb.append(">");
    System.out.println(sb);
  }
}

// Queue 사용
//  public static void main(String[] args) throws Exception {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    int N = Integer.parseInt(st.nextToken()); // 총 인원 수
//    int K = Integer.parseInt(st.nextToken()); // K번째 사람 제거
//
//    Queue<Integer> queue = new LinkedList<>();
//    int[] results = new int[N];
//
//    for (int i = 1; i <= N; i++) {
//      queue.add(i);
//    }
//
//    int idx = 0;
//    while (!queue.isEmpty()) {
//
//      for (int i = 0; i < K - 1; i++) {
//        queue.add(queue.poll());
//      }
//      results[idx++] = queue.poll();
//    }
//
//    StringBuilder sb = new StringBuilder();
//    sb.append("<");
//    for (int i = 0; i < N; i++) {
//      sb.append(results[i]);
//      if (i < N - 1) {
//        sb.append(", ");
//      }
//    }
//    sb.append(">");
//    System.out.println(sb);
//  }

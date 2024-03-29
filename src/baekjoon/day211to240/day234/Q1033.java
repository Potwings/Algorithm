package baekjoon.day211to240.day234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 개선 사항 두 재료 모두 이미 비율을 가지고 있는 경우는 없다.
 */
public class Q1033 {

  static ArrayList<Node>[] adjListArr;
  static boolean[] visitArr;
  static long[] result;

  // DFS 활용 풀이
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = null;
    adjListArr = new ArrayList[N];
    visitArr = new boolean[N];
    for (int i = 0; i < N; i++) {
      adjListArr[i] = new ArrayList<>();
    }
    long lcm = 1; // 모든 비율들의 최소 공배수
    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      int q = Integer.parseInt(st.nextToken());

      long gcd = gcd(p, q);
      p /= gcd;
      q /= gcd;
      lcm *= p * q;
      adjListArr[a].add(new Node(b, p, q));
      adjListArr[b].add(new Node(a, q, p));
    }

    result = new long[N];
    result[0] = lcm;
    DFS(0);

    // result 배열 최대 공약수로 비율 간소화
    long gcd = gcd(result[0], result[1]);
    for (int i = 2; i < N; i++) {
      gcd = gcd(gcd, result[i]);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(result[i] / gcd).append(" ");
    }
    System.out.println(sb);
  }

  //이전 값
  public static void DFS(int num) {

    visitArr[num] = true;
    List<Node> adjList = adjListArr[num];
    for (Node node : adjList) {
      if (!visitArr[node.other]) {
        result[node.other] = result[num] / node.p * node.q;
        DFS(node.other);
      }
    }
  }

  public static long gcd(long a, long b) {
    long r = a % b;
    if (r == 0) {
      return b;
    }
    return gcd(b, r);
  }

  public static class Node {

    int other;
    int p;
    int q;

    public Node(int other, int p, int q) {
      this.other = other;
      this.p = p;
      this.q = q;
    }
  }

  //Map 활용한 풀이
//  public static void main(String[] args) throws Exception {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int N = Integer.parseInt(br.readLine());
//    StringTokenizer st = null;
//    List<Map<Integer, Integer>> ratioMapList = new ArrayList<>();
//    for (int i = 1; i < N; i++) {
//      st = new StringTokenizer(br.readLine());
//      int a = Integer.parseInt(st.nextToken());
//      int b = Integer.parseInt(st.nextToken());
//      int p = Integer.parseInt(st.nextToken());
//      int q = Integer.parseInt(st.nextToken());
//      int gcd = gcd(p, q); // 비율 약분하여 저장
//      p /= gcd;
//      q /= gcd;
//      Map<Integer, Integer> ratioMap = new HashMap<>();
//      ratioMap.put(a, p);
//      ratioMap.put(b, q);
//      ratioMapList.add(ratioMap);
//    }
//
//    // 그냥 배열에 이전 값들 저장하고 있다가 0이 아닌 값이 최소 공배수를 구하여 비율을 맞춰준다.
//    for (int i = 0; i < N; i++) {
//      int beforeRatio = 0; // 이전 비율을 저장
//      List<Map<Integer, Integer>> containsMapList = new ArrayList<>();
//      for (Map<Integer, Integer> ratioMap : ratioMapList) {
//        // 해당 재료에 대한 모든 비율의 최소 공배수 계산
//        if (ratioMap.containsKey(i)) {
//          containsMapList.add(ratioMap);
//          int ratio = ratioMap.get(i);
//          if (beforeRatio == 0) {
//            beforeRatio = ratio;
//          } else {
//            beforeRatio = ratio * beforeRatio / gcd(beforeRatio, ratio);
//          }
//        }
//      }
//
//      if (containsMapList.size() >= 2) {
//        Map<Integer, Integer> totalRatioMap = new HashMap<>();
//        totalRatioMap.put(i, beforeRatio);
//        for (Map<Integer, Integer> ratioMap : containsMapList) {
//          ratioMapList.remove(ratioMap);
//          int ratio = ratioMap.remove(i);
//          int share = beforeRatio / ratio; // 다른 비율에 곱해주어야하는 값
//          for (int key : ratioMap.keySet()) {
//            totalRatioMap.put(key, ratioMap.get(key) * share); // 변경된 비율에 맞춰 다른 재료들도 변경
//          }
//        }
//        ratioMapList.add(totalRatioMap);
//      }
//    }
//    StringBuilder sb = new StringBuilder();
//    Map<Integer, Integer> resultRatioMap = ratioMapList.get(0);
//    for (int j = 0; j < N; j++) {
//      sb.append(resultRatioMap.get(j)).append(" ");
//    }
//    System.out.println(sb);
//  }

}

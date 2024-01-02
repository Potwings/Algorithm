package baekjoon.day161to170.day165;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q18870 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] numArr = new int[N];
    int[] sortArr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      numArr[i] = num;
      sortArr[i] = num;
    }
    Arrays.sort(sortArr);
    Map<Integer, Integer> rankMap = new HashMap<>();
    int rank = 0;
    for (int i = 0; i < N; i++) {
      if (!rankMap.containsKey(sortArr[i])) {
        rankMap.put(sortArr[i], rank);
        rank++;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < N; i++) {
      sb.append(rankMap.get(numArr[i])).append(" ");
    }
    System.out.println(sb);
  }
//  public static void main(String[] args) throws Exception {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int N = Integer.parseInt(br.readLine());
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    int[] inputArr = new int[N];
//    TreeSet<Integer> numSet = new TreeSet<>();
//    for (int i = 0; i < N; i++) {
//      int num = Integer.parseInt(st.nextToken());
//      inputArr[i] = num;
//      numSet.add(num);
//    }
//
//    Integer[] numArr = numSet.toArray(new Integer[0]);
//    StringBuilder sb = new StringBuilder();
//    for (int i = 0; i < N; i++) {
//      sb.append(Arrays.binarySearch(numArr, inputArr[i])).append(" ");
//    }
//
//    System.out.println(sb);
//  }
}

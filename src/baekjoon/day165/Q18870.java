package baekjoon.day165;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Q18870 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] inputArr = new int[N];
    TreeSet<Integer> numSet = new TreeSet<>();
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      inputArr[i] = num;
      numSet.add(num);
    }

    Integer[] numArr = numSet.toArray(new Integer[0]);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(Arrays.binarySearch(numArr, inputArr[i])).append(" ");
    }

    System.out.println(sb);
  }
}
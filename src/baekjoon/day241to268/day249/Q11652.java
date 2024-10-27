package baekjoon.day241to268.day249;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q11652 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Map<Long, Number> countMap = new HashMap<>();
    for (int i = 0; i < N; i++) {
      long num = Long.parseLong(br.readLine());
      if (countMap.containsKey(num)) {
        countMap.get(num).count++;
      } else {
        countMap.put(num, new Number(num));
      }
    }

    List<Number> numList = new ArrayList<>(countMap.values());
    Collections.sort(numList);
    System.out.println(numList.get(0));
  }

  public static class Number implements Comparable<Number> {

    long num;
    int count;

    public Number(long num) {
      this.num = num;
      count = 1;
    }

    @Override
    public int compareTo(Number o) {
      if (count != o.count) {
        return o.count - count;
      }

      return (num > o.num) ? 1 : -1; // long overflow 방지
    }
  }

}

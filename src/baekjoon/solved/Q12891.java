package baekjoon.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q12891 {

  static int result = 0;
  static int checkedCount = 0;
  static int[] limit = new int[4];
  static Map<Character, Integer> countMap = new HashMap<>();
  static Map<Character, Integer> acgtCountMap = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());
    String str = br.readLine();
    limit = new int[4];
    st = new StringTokenizer(br.readLine());

    char[] acgtArr = {'A', 'C', 'G', 'T'};
    for (int i = 0; i < 4; i++) {
      int count = Integer.parseInt(st.nextToken());
      acgtCountMap.put(acgtArr[i], count);
      if (count == 0) {
        checkedCount++;
      }
    }

    countMap.put('A', 0);
    countMap.put('C', 0);
    countMap.put('G', 0);
    countMap.put('T', 0);
    for (int i = 0; i < P - 1; i++) {
      increase(str.charAt(i));
    }

    for (int i = P - 1; i < S; i++) {
      increase(str.charAt(i));

      if (checkedCount == 4) {
        result++;
      }

      decrease(str.charAt(i - P + 1));
    }

    System.out.println(result);
  }

  public static void decrease(char c) {
    int beforeCount = countMap.get(c);
    if (beforeCount == acgtCountMap.get(c)) {
      checkedCount--;
    }
    countMap.put(c, beforeCount - 1);
  }

  public static void increase(char c) {
    int newCount = countMap.get(c) + 1;
    countMap.put(c, newCount);
    if (newCount == acgtCountMap.get(c)) {
      checkedCount++;
    }
  }
}

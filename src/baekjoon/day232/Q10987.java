package baekjoon.day232;

import java.util.*;
import java.io.*;

public class Q10987 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Character[] vowelArr = {'a', 'e', 'i', 'o', 'u'};
    Set<Character> charSet = new HashSet<>(Arrays.asList(vowelArr));
    String input = br.readLine();
    int count = 0;
    for (int i = 0; i < input.length(); i++) {
      if (charSet.contains(input.charAt(i))) {
        count++;
      }
    }
    System.out.println(count);
  }
}
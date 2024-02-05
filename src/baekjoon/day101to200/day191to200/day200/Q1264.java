package baekjoon.day101to200.day191to200.day200;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1264 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Character[] vowelArr = {'a', 'e', 'i', 'o', 'u'};
    Set<Character> vowels = new HashSet<>(Arrays.asList(vowelArr));
    String input;
    while (!(input = br.readLine().toLowerCase()).equals("#")) {
      int count = 0;
      for (char c : input.toCharArray()) {
        if (vowels.contains(c)) {
          count++;
        }
      }
      System.out.println(count);
    }

  }

}

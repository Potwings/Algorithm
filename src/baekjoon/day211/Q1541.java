package baekjoon.day211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 개선 사항
 * -를 제외하고 +들을 괄호로 묶어서 진행하면 되므로
 * split을 "-" 기준으로 진행하고 연산 진행하면 더 쉽게 풀 수 있다.
 */
public class Q1541 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputArr = br.readLine().split("-");
    long result = 0;
    for (int i = 0; i < inputArr.length; i++) {
      long tempSum = 0;
      for (String num : inputArr[i].split("\\+")) {
        tempSum += Long.parseLong(num);
      }
      // 처음 발생한 tempSum만 더해주고 나머지는 뺴준다.
      if (i == 0) {
        result += tempSum;
      } else {
        result -= tempSum;
      }
    }
    System.out.println(result);
  }

//  public static void main(String[] args) throws Exception {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    String input = br.readLine();
//    // 숫자와 연산자를 나누기 위해 연산자 앞뒤에 공백 추가
//    input = input.replace("+", " + ");
//    input = input.replace("-", " - ");
//    Queue<String> strQueue = new LinkedList<>(Arrays.asList(input.split(" ")));
//
//    long result = Long.parseLong(strQueue.poll());
//    // 처음에 +가 나온 경우 -가 나올 때까지 합 진행한다.
//    while(!strQueue.isEmpty() && strQueue.poll().equals("+")) {
//      result += Long.parseLong(strQueue.poll());
//    }
//
//    // -가 나온 시점에서는 그 뒤의 수들 합해서 계산한다.
//    while(!strQueue.isEmpty()) {
//        long tempSum = Long.parseLong(strQueue.poll());
//        // - 이후에 +들은 묶어서 한번에 빼준다.
//        while(!strQueue.isEmpty() && strQueue.poll().equals("+")){
//          tempSum += Long.parseLong(strQueue.poll());
//        }
//        // -가 나왔을 경우 결과에서 빼주고 다시 합 진행
//        result -= tempSum;
//    }
//    System.out.println(result);
//  }
}

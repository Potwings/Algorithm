package baekjoon.day1to100.day10to50.day35;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 * <p>
 * 입력
 * 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
 * <p>
 * 출력
 * 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 */

/**
 * 개선 사항
 * 카운팅 정렬을 사용해서도 가능하다.
 */
public class Q1427 {

    // 카운팅 정렬을 활용
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] countArr = new int[10];
        int num = Integer.parseInt(br.readLine());

        while (num > 0) {
            countArr[num % 10]++;
            num /= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int count = countArr[i];
            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }

        System.out.println(sb.toString());
    }

    // 자바 내장 배열을 활용
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int inputNum = Integer.parseInt(br.readLine());
//        int intLength = (int) (Math.log10(inputNum) + 1);
//        //Collections.reverseOrder()를 위하여 Integer로 배열 생성
//        Integer[] numArr = new Integer[intLength];
//
//        // 입력받은 수의 각 자리수를 배열로 변환
//        for (int i = 0; i < intLength; i++) {
//            numArr[i] = inputNum % 10;
//            inputNum /= 10;
//        }
//
//        // 큰 수부터 출력해야하므로 내림차순 정렬
//        Arrays.sort(numArr, Collections.reverseOrder());
//
//        StringBuilder sb = new StringBuilder();
//        for (int num : numArr) {
//            sb.append(num);
//        }
//
//        System.out.println(sb.toString());
//    }
}

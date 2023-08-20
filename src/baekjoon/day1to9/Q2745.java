package baekjoon.day1to9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
 * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
 * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
 */

/**
 * 개선 사항
 * Character.isDigit() 함수를 이용하면 해당 문자가 숫자인지 더 쉽게 알 수 있다.
 * char의 숫자값을 계산할 때 문자를 넣어서 계산하는 방법도 있었다.
 * 제곱을 사용할 수도 있으나 기존에 있던 수에 진법만큼 곱하여 반복문을 진행하는 방법도 있었다.
 * ex)
 * for (int i = 0; i < N.length(); i++) {
 * char c = N.charAt(i);
 * int num = Character.isDigit(c) ? c - '0' : c - 'A' + 10;
 * result = result * B + num;
 * }
 */
public class Q2745 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String num = st.nextToken(); // 숫자 입력 (알파벳 포함)
        int system = Integer.parseInt(st.nextToken()); // 몇 진법으로 진행할 지
        int result = 0;
        int numLength = num.length();
//        for (int i = 0; i < numLength; i++) {
//            char a = num.charAt(i);
//            int charValue = (int) a;
//            int intValue = charValue > 57 ? charValue - 55 : charValue - 48; // char에서 숫자 1~9는 49~57 알파벳 대문자 A~Z는 65~90 이므로 문제에 맞게 맞춰준다.
//            result += (int) Math.pow(system, numLength - i - 1) * intValue; // 해당 진법의 자리수(총 길이 - 해당 문자 index) - 1 만큼 제곱 후 int value 곱한다.
//        }

        for(int i = 0; i < numLength; i++){
            char a = num.charAt(i);
            int intValue = Character.isDigit(a) ? a - '0' : a - 'A' + 10;
            result = result * system + intValue;
        }
        System.out.println(result);
    }
}

package baekjoon.day111to120.day114;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 개선 사항
 * Integer.toBinaryString()을 통하여 숫자를 이진수로 변환할 수 있다.
 */
public class Q1212 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] inputArr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(inputArr[0] - '0')); // 첫번째의 경우 앞의 0을 제거해야하므로 위와 같이 진행
        for (int i = 1; i < inputArr.length; i++) {
            int current = inputArr[i] - '0';
            String binaryNum = Integer.toBinaryString(current);
            sb.append("0".repeat(3 - binaryNum.length()));
            sb.append(binaryNum);
        }
        System.out.println(sb);
    }
}
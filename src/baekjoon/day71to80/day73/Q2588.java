package baekjoon.day71to80.day73;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2588 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int tempNum = num2;
        int digit1 = tempNum % 10;
        tempNum /= 10;
        int digit10 = tempNum % 10;
        tempNum /= 10;
        int digit100 = tempNum;

        StringBuilder sb = new StringBuilder();
        sb.append(num1 * digit1).append("\n")
                .append(num1 * digit10).append("\n")
                .append(num1 * digit100).append("\n")
                .append(num1 * num2);

        System.out.println(sb);
    }
}

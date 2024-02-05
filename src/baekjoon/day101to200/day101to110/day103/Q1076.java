package baekjoon.day101to200.day101to110.day103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Q1076 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] colorArr = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        List<String> colorList = Arrays.asList(colorArr);
        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();

        // 값들은 해당 색의 인덱스 값이고 곱은 해당 색의 인덱스 값을 n이라 할 때 10^n 이다.
        int value1 = colorList.indexOf(color1);
        int value2 = colorList.indexOf(color2);
        long multiple = (long) Math.pow(10, colorList.indexOf(color3)); // int 최대값 초과하므로 long으로 진행
        System.out.println((value1 * 10 + value2) * multiple);
    }

}

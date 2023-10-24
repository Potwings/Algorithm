package baekjoon.day1to100.day10to50.day37;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문제
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 * <p>
 * 길이가 짧은 것부터
 * 길이가 같으면 사전 순으로
 * 단, 중복된 단어는 하나만 남기고 제거해야 한다.
 * <p>
 * 입력
 * 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000)
 * 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
 * 주어지는 문자열의 길이는 50을 넘지 않는다.
 * <p>
 * 출력
 * 조건에 따라 정렬하여 단어들을 출력한다.
 */
public class Q1181 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strArr = new String[N];

        for (int i = 0; i < N; i++) {
            strArr[i] = br.readLine();
        }

        // 중복 제거
        strArr = Arrays.stream(strArr).distinct().toArray(String[] :: new);
        // str1과 str2의 길이가 동일할 경우 둘을 알파벳 순으로 정렬 str1.compareTo(str2)는 알파벳 오름차순 정렬이다. 내림차순은 str2.compareTo(str1)
        Arrays.sort(strArr, (str1, str2) -> str1.length() == str2.length() ? str1.compareTo(str2) : str1.length() - str2.length());

        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str).append("\n");
        }

        System.out.println(sb.toString());
    }
}

package baekjoon.day101to110.day101.day104;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1032 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] fileNames = new String[N];
        for (int i = 0; i < N; i++) {
            fileNames[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        String firstFile = fileNames[0];
        check:
        for (int i = 0; i < firstFile.length(); i++) {
            char c = firstFile.charAt(i);
            for (int j = 1; j < N; j++) {
                if (c != fileNames[j].charAt(i)) {
                    // 이전의 값과 다를 경우 ?를 추가한 후 다음 문자열을 확인한다.
                    sb.append("?");
                    continue check;
                }
            }
            sb.append(c);
        }

        System.out.println(sb);
    }
}

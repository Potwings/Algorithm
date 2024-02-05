package baekjoon.day101to200.day131to140.day137;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarfArr = new int[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            int tall = Integer.parseInt(br.readLine());
            dwarfArr[i] = tall;
            total += tall;
        }

        all:
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (total - dwarfArr[i] - dwarfArr[j] == 100) {
                    dwarfArr[i] = 0;
                    dwarfArr[j] = 0;
                    break all;
                }
            }
        }

        Arrays.sort(dwarfArr);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < 9; i++) {
            sb.append(dwarfArr[i]).append("\n");
        }

        System.out.println(sb);
    }
}

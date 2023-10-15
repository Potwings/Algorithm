package baekjoon.day91;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12891 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        int[] acgtCount = new int[4];
        for (int i = 0; i < 4; i++) {
            acgtCount[i] = Integer.parseInt(st.nextToken());
        }

        int[] myCount = new int[4];
        for (int i = 0; i < P - 1; i++) {
            addCount(str.charAt(i), myCount);
        }

        int result = 0;
        for (int j = P - 1; j < S; j++) {
            addCount(str.charAt(j), myCount);
            boolean checkCount = true;
            for (int i = 0; i < 4; i++) {
                if (myCount[i] < acgtCount[i]) {
                    checkCount = false;
                    break;
                }
            }
            if (checkCount) {
                result++;
            }
            discount(str.charAt(j - P + 1), myCount);
        }

        System.out.println(result);
    }

    public static void addCount(char c, int[] myCount) {
        switch (c) {
            case 'A':
                myCount[0]++;
                break;
            case 'C':
                myCount[1]++;
                break;
            case 'G':
                myCount[2]++;
                break;
            case 'T':
                myCount[3]++;
        }
    }

    public static void discount(char c, int[] myCount) {
        switch (c) {
            case 'A':
                myCount[0]--;
                break;
            case 'C':
                myCount[1]--;
                break;
            case 'G':
                myCount[2]--;
                break;
            case 'T':
                myCount[3]--;
        }
    }

}


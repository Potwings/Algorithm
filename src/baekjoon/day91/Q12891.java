package baekjoon.day91;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 특정 문자 추가 제거 시 해당 문자에 대해서만 개수 검사를 진행하면 된다.
 *
 * 별도의 메소드에서 진행해야하는 로직이 있을 경우 클래스 변수로 선언하는 방식도 고려하자
 */
public class Q12891 {
    static int checkedCount = 0;
    static int[] acgtCount = new int[4];
    static int[] myCount = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            acgtCount[i] = Integer.parseInt(st.nextToken());
            if (acgtCount[i] == 0) {
                // 0일 경우 항상 참이므로 checkCount 증가
                checkedCount++;
            }
        }

        for (int i = 0; i < P - 1; i++) {
            addCount(str.charAt(i));
        }

        int result = 0;
        for (int j = P - 1; j < S; j++) {
            addCount(str.charAt(j));

            if (checkedCount == 4) {
                result++;
            }

            discount(str.charAt(j - P + 1));
        }

        System.out.println(result);
    }

    public static void addCount(char c) {
        // 문자 하나씩 변경되므로 acgtCount배열의 개수와 동일할 때만 checkedCount를 증가시켜주어야한다.
        switch (c) {
            case 'A':
                myCount[0]++;
                if(myCount[0] == acgtCount[0])
                    checkedCount++;
                break;
            case 'C':
                myCount[1]++;
                if(myCount[1] == acgtCount[1])
                    checkedCount++;
                break;
            case 'G':
                myCount[2]++;
                if(myCount[2] == acgtCount[2])
                    checkedCount++;
                break;
            case 'T':
                myCount[3]++;
                if(myCount[3] == acgtCount[3])
                    checkedCount++;
                break;
        }
    }

    public static void discount(char c) {
        // 문자 하나씩 변경되므로 개수가 감소하기 전 값이 acgtCount배열의 개수와 동일할 때만 checkedCount를 감소시켜주어야 한다.
        switch (c) {
            case 'A':
                if(myCount[0] == acgtCount[0])
                    checkedCount--;
                myCount[0]--;
                break;
            case 'C':
                if(myCount[1] == acgtCount[1])
                    checkedCount--;
                myCount[1]--;
                break;
            case 'G':
                if(myCount[2] == acgtCount[2])
                    checkedCount--;
                myCount[2]--;
                break;
            case 'T':
                if(myCount[3] == acgtCount[3])
                    checkedCount--;
                myCount[3]--;
                break;
        }
    }

}

package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Q2566 {

    /**
     * 문제
     * <그림 1>과 같이 9×9 격자판에 쓰여진 81개의 자연수 또는 0이 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.
     */

    /**
     * 이차원 배열에 포함되어 있는 문제였으나 굳이 이차원 배열을 사용할 필요가 없었다.
     *
     * 개선 사항
     * 1. 별도의 변수를 만들 필요 없이 반복문에서 사용하던 변수를 최대값 위치 계산 시 사용한다.
     * 2. 문제에서 0도 주어진다고 했는데 0이 최대값이 경우일 경우를 고려하지 않았음.
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int resultNum = -1;
        int resultColumn = -1;
        int resultRow = -1;
        String line = null;

        for (int i = 0; i < 9; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num > resultNum) {
                    resultNum = num;
                    resultRow = i + 1;
                    resultColumn = j + 1;
                }
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(resultNum + "\n");
        stringBuffer.append(resultRow);
        stringBuffer.append(" ");
        stringBuffer.append(resultColumn);

        System.out.println(stringBuffer.toString());
    }
}

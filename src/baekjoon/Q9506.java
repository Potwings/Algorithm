package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 문제
 * 어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.
 * 예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.
 * n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.
 */

/**
 * 개선 사항
 * 1. 완전수인지 판단하기 위한 합을 리스트에 추가할 때 합도 동시에 진행하여 구해두면 불필요한 반복을 줄일 수 있다.
 * 2. 1은 모든 수의 약수이므로 항상 포함하면 된다.(반복문 2부터 시작하면 된다.)
 * 3. 자기 자신의 수는 항상 처음에 작성되므로 기본적으로 세팅해주면 된다.
 */
public class Q9506 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = 0;
        List<Integer> divisorList = null;
        while ((num = Integer.parseInt(br.readLine())) != -1) {

            divisorList = new ArrayList<>();
            int divisorSum = 1;

            for (int i = 2; i < num; i++) {
                // 모든 수의 약수에 1이 포함되므로 2부터 시작
                if (num % i == 0) {
                    //num의 약수일 경우 List에 추가
                    divisorList.add(i);
                    //추후 완전수인지 판단할 때 사용하기 위한 합을 구한다.
                    divisorSum += i;
                }
            }

            bw.write(String.valueOf(num)); // 어떤 결과던 num이 가장 먼저 나오므로 세팅
            if (divisorSum == num) {
                // 완전수일 경우
                bw.write(" = 1"); // 1은 항상 약수이므로 추가

                for (int divisor : divisorList) {
                    bw.write(" + " + divisor);
                }
                bw.write("\n");
                continue;
            }

            // 완전수가 아닐 경우
            bw.write(" is NOT perfect.\n");
        }

        bw.flush();
        bw.close();
    }
}

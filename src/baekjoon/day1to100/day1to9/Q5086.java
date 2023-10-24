package baekjoon.day1to100.day1to9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제
 * 4 × 3 = 12이다.
 * 이 식을 통해 다음과 같은 사실을 알 수 있다.
 * 3은 12의 약수이고, 12는 3의 배수이다.
 * 4도 12의 약수이고, 12는 4의 배수이다.
 * 두 수가 주어졌을 때, 다음 3가지 중 어떤 관계인지 구하는 프로그램을 작성하시오.
 * - 첫 번째 숫자가 두 번째 숫자의 약수이다.(factor)
 * - 첫 번째 숫자가 두 번째 숫자의 배수이다.(multiple)
 * - 첫 번째 숫자가 두 번째 숫자의 약수와 배수 모두 아니다.(neither)
 */
public class Q5086 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());

            if(num1 == 0) {
                // 자연수만 주어지므로 0이 나왔을 경우 마지막 줄이다.
                break;
            }

            int num2 = Integer.parseInt(st.nextToken());

            if(num2 % num1 == 0){
                // 두 번째 수가 첫 번째 수로 나누어 떨어지는 경우(약수)
                bw.write("factor\n");
                continue;
            }

            if(num1 % num2 == 0){
                // 첫 번째 수가 두 번째 수로 나누어 떨어지는 경우(배수)
                bw.write("multiple\n");
                continue;
            }

            bw.write("neither\n"); // 이외의 경우
        }

        bw.flush();
        bw.close();
    }
}

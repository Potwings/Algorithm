package baekjoon.day23;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * 상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다.
 * 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
 * 상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다.
 * 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
 * 상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)
 * <p>
 * 출력
 * 상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.
 */

/**
 * 개선 사항
 * 문제를 잘 읽자
 * 처음에 5로 나눈 후 3으로 나누어 떨어지지 않으면 -1을 출력한다는 생각으로 진행
 * 그 다음 5로 나누어 떨어지지 않으면 무조건 3으로 나누는 것으로 생각하여 진행
 * 그 다음은 result 값 계산하는 방식을 제대로 확인하지 않고 제출
 */
public class Q2839 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        // 5로 나누어 떨어지는 만큼 나눈 후 나머지를 3으로 나누어 준다.
        result += N / 5;
        int temp = N % 5;

        while (temp > 0 && temp % 3 > 0) {
            /**
             * 5kg 봉지로 나눈 후 나머지의 설탕이 3으로 나누어 떨어지지 않는 경우
             * 5kg 봉지에 담았던 설탕을 하나씩 풀며 3으로 나누어 떨어지는 지 확인한다.
             */

            if (result == 0) {
                // 더 이상 풀 5kg 봉지가 없을 경우 -1을 결과로 반환한다.
                result = -1;
                break;
            }

            result--;
            temp += 5;
        }

        if(result > -1) {
            // 나누어 떨어지는 경우 3kg로 나눈 봉지 수를 추가해준다.
            result += temp / 3;
        }

        System.out.println(result);
    }
}

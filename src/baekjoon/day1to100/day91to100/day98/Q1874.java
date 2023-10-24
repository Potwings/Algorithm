package baekjoon.day1to100.day91to100.day98;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 개선 사항
 * 추가되었을 경우를 확인하는게 아닌 목표가 되는 수를 메인으로 생각하여 확인하면 불필요한 확인을 줄일 수 있다.
 * <p>
 * 초기 방식 -> 어떤 수가 추가되던 비교를 진행
 * 개선 방식 -> 비교를 진행해야 하는 수가 될 때 까지는 비교하지 않고 진행
 */
public class Q1874 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> numStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int addNum = 1;
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            if (target >= addNum) {
                // taget에 도달할 때까지 추가
                while (target >= addNum) {
                    numStack.push(addNum++);
                    sb.append("+").append("\n");
                }
                // addNum이 target이 되었을 경우 추출
                numStack.pop();
                sb.append("-").append("\n");
            } else {
                // target이 이미 stack에 포함되어있는 경우
                int num = numStack.pop();
                /**
                 * 중복되는 수가 없기 떄문에 stack에는 target이 무조건 존재하고
                 * 오름차순으로 추가되었기 때문에 해당 수보다 작은 수가 나올 수는 없다.
                 * 따라서 해당 수보다 큰 수가 나왔을 경우 "NO" 출력 후 중단한다.
                 */
                if (num < target) {
                    // target은 이미 stack에 포함되어있으나 stack에서 추출했을 때 바로 안나오면 해당 수열을 만들 수 없으므로 실패
                    System.out.println("NO");
                    return;
                }
                // 정상적으로 추출된 경우 결과에 "-" 추가
                sb.append("-").append("\n");
            }
        }

        System.out.println(sb);
    }
}


package baekjoon.day1to100.day91to100.day100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 이전의 수들을 스택이 담아 처리하는 방식은 생각하지 않음
 * 이후의 수들은 스택에 담아둔 후 꺼내서 비교 후 바로 결과값을 작성하려고만 생각하였음.
 * 모든 수를 조건 확인과 동시에 결과값을 작성하려는 생각에 갇혀있었음
 *
 * 또 스택에 담을 때 오큰수 여부를 확인 후 추가할 경우 스택의 위에 있는 수는 아래에 있는 수보다 무조건 작다.
 * 위의 수보다 작은 수일 경우 위의 수가 추가될 때 위의 수를 오큰수로 판단하여 이미 스택에서 제거되었다.
 */
public class Q17298 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numArr = new int[N];
        int[] resultArr = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> numStack = new Stack<>();
        numStack.push(0);
        // 새로운 수가 추가될 때 기존 값들보다 큰 지 확인 후 진행
        for (int i = 1; i < N; i++) {
            int num = numArr[i];
            while (!numStack.isEmpty() && numArr[numStack.peek()] < num) {
                int idx = numStack.pop();
                resultArr[idx] = num;
            }

            numStack.push(i);
        }

        // 모든 수열을 확인했음에도 오큰수가 없는 경우
        while (!numStack.isEmpty()) {
            int idx = numStack.pop();
            resultArr[idx] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int result : resultArr) {
            sb.append(result).append(" ");
        }
        System.out.println(sb);
    }
}

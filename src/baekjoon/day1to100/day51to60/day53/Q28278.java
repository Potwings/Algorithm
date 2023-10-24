package baekjoon.day1to100.day51to60.day53;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 문제
 * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 * 명령은 총 다섯 가지이다.
 * 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
 * 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
 * 3: 스택에 들어있는 정수의 개수를 출력한다.
 * 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 * <p>
 * 입력
 * 첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
 * 둘째 줄부터 N개 줄에 명령이 하나씩 주어진다.
 * 출력을 요구하는 명령은 하나 이상 주어진다.
 * <p>
 * 출력
 * 출력을 요구하는 명령이 주어질 때마다 명령의 결과를 한 줄에 하나씩 출력한다.
 */

/**
 * 개선 사항
 * 명령어가 1일 경우 별도로 분기처리할 필요 없이 1일 경우만 명령어 다음의 정수를 불러오면 된다.
 *
 * split을 쓸 필요 없이 chatAt을 이용하여 첫번째 값만 가져오는 것이 성능상 더 좋음
 * switch문 안의 if문을 삼항연산자로 더 간단하게 할 수 있었음
 * 1번 케이스에서 charAt으로 push값 받을 경우 두자리수 이상이면 처리 못함 -> StringTokenizer로 처리
 */
public class Q28278 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "1":
                    numStack.push(Integer.parseInt(st.nextToken()));
                    continue; //1번 케이스의 경우 출력값이 없어 개행 필요 없다.
                case "2":
                    if (numStack.empty()) {
                        sb.append(-1);
                    } else {
                        sb.append(numStack.pop());
                    }
                    break;
                case "3":
                    sb.append(numStack.size());
                    break;
                case "4":
                    sb.append(numStack.empty() ? 1 : 0);
                    break;
                case "5":
                    if (numStack.empty()) {
                        sb.append(-1);
                    } else {
                        sb.append(numStack.peek());
                    }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

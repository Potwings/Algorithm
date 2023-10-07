package baekjoon.day61to70.day69;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q12789 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> subLine = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int callNum = 1;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (true) {
                if (num == callNum) {
                    callNum++;
                } else {
                    if (!subLine.isEmpty()) {
                        int subNum = subLine.peek();
                        if (subNum == callNum) {
                            subLine.pop();
                            callNum++;
                            continue; // line에 있는 기존 수를 이용하여 다시 비교
                        }
                        if (subNum < num) {
                            // subLine에 담겨있는 기존의 수가 새로 들어올 수보다 작을 경우 정상 분배 불가
                            System.out.println("Sad");
                            return;
                        }
                    }
                    subLine.push(num);
                }
                break;
            }
        }
        System.out.println("Nice");
    }
}
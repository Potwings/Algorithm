package baekjoon.day106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 방향이 없는 그래프인데 양방향으로 고려하지 않음
 */
public class Q11724 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> adjListList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjListList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int point1 = Integer.parseInt(st.nextToken());
            int point2 = Integer.parseInt(st.nextToken());
            adjListList.get(point1).add(point2);
            adjListList.get(point2).add(point1);
        }

        boolean[] visitArr = new boolean[N + 1];
        int result = 0;
        Stack<Integer> numStack = new Stack<>();
        for (int j = 1; j <= N; j++) {
            if (!visitArr[j]) {
                result++;
                numStack.push(j);
                while (!numStack.isEmpty()) {
                    int checkNum = numStack.pop();
                    List<Integer> adjList = adjListList.get(checkNum);
                    for (int i = 0; i < adjList.size(); i++) {
                        int num = adjList.get(i);
                        if (!visitArr[num]) {
                            numStack.push(num);
                            visitArr[num] = true;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}

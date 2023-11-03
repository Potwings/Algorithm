package baekjoon.day110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 가능한 지 여부를 확인하는 문제이므로 성공 값을 class 변수로 관리하는 방안도 고려해보자
 */
public class Q13023 {
    static ArrayList<Integer>[] friendListArr;
    static boolean[] visitArr;
    static boolean result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        friendListArr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            friendListArr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());
            // 친구 관계는 양방향이다.
            friendListArr[person1].add(person2);
            friendListArr[person2].add(person1);
        }

        for (int i = 0; i < N; i++) {
            // 독립시행이므로 방문 배열 매번 초기화한다.
            visitArr = new boolean[N];
            int depth = 0; // 총 4번의 관계를 확인해야함.
            DFS(i, depth);
            if (result) {
                break;
            }
        }
        if (result) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void DFS(int person, int depth) {
        if (depth == 4) {
            result = true;
            return;
        }
        visitArr[person] = true;
        for (int friend : friendListArr[person]) {
            if (!visitArr[friend]) {
                DFS(friend, depth + 1);
            }
        }
        // 검사하던 사람을 통하여 친구관계가 확인 안될 경우 방문하지 않은 상태로 돌려놓은 뒤 다시 탐색
        visitArr[person] = false;
    }
}

package baekjoon.day75;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 그냥 인덱스 값을 Map의 key로 저장 후 Map을 활용하여 풀이도 가능할 듯 함 -> 인덱스가 변경되는 사항을 반영해야해서 불편함
public class Q2346 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Ballon> ballonDeque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            ballonDeque.offer(new Ballon(i, Integer.parseInt(st.nextToken())));
        }

        // 첫번째 풍선 확인
        Ballon ballon = ballonDeque.pollFirst();
        int paper = ballon.paper;
        StringBuilder sb = new StringBuilder();
        sb.append("1 "); // 첫번쨰 풍선 항상 우선 제거
        while (!ballonDeque.isEmpty()) {
            if (paper < 0) {
                // 종이에 적힌 수가 음수일 경우 뒤에서부터 제거하여 앞에 추가한다.
                for (int i = paper; i < -1; i++) {
                    ballonDeque.offerFirst(ballonDeque.pollLast());
                }
                // paper값 만큼 이동 후 나온 풍선 제거
                ballon = ballonDeque.pollLast();
            } else {
                // 종이에 적힌 수가 양수일 경우 앞에서부터 제거하여 뒤에 추가한다.
                for (int i = 1; i < paper; i++) {
                    ballonDeque.offerLast(ballonDeque.pollFirst());
                }
                // paper값 만큼 이동 후 나온 풍선 제거
                ballon = ballonDeque.pollFirst();
            }

            sb.append(ballon.idx).append(" "); // 제거한 풍선값 저장
            paper = ballon.paper; // 해당 풍선의 종이값으로 while loop 진행
        }// end while

        System.out.println(sb);
    }

    public static class Ballon {
        int idx; // 처음 인덱스 값
        int paper; // 종이에 적힌 정수 값

        public Ballon(int idx, int paper) {
            this.idx = idx;
            this.paper = paper;
        }
    }
}

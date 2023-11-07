package baekjoon.day101to110.day101.day105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);
                if (abs1 == abs2) {
                    // 절대값이 동일할 경우 일반값 비교
                    return o1 - o2;
                }
                return abs1 - abs2;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sb.append(priorityQueue.isEmpty() ? 0 : priorityQueue.poll()).append("\n");
            } else {
                priorityQueue.offer(num);
            }
        }
        System.out.println(sb);
    }

}

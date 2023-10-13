package baekjoon.day89;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] materials = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(materials);
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (materials[i] > M) {
                break;
            }
            for (int j = i + 1; j < N; j++) {
                int sum = materials[i] + materials[j];
                if (sum >= M) {
                    if (sum == M) {
                        result++;
                    }
                    break;
                }
            }
        }

        System.out.println(result);
    }
}

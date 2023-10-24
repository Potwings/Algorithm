package baekjoon.day1to100.day51to60.day52;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * 직선으로 되어있는 도로의 한 편에 가로수가 임의의 간격으로 심어져있다.
 * KOI 시에서는 가로수들이 모두 같은 간격이 되도록 가로수를 추가로 심는 사업을 추진하고 있다.
 * KOI 시에서는 예산문제로 가능한 한 가장 적은 수의 나무를 심고 싶다.
 * 편의상 가로수의 위치는 기준점으로 부터 떨어져 있는 거리로 표현되며, 가로수의 위치는 모두 양의 정수이다.
 * <p>
 * 예를 들어, 가로수가 (1, 3, 7, 13)의 위치에 있다면 (5, 9, 11)의 위치에 가로수를 더 심으면 모든 가로수들의 간격이 같게 된다.
 * 또한, 가로수가 (2, 6, 12, 18)에 있다면 (4, 8, 10, 14, 16)에 가로수를 더 심어야 한다.
 * <p>
 * 심어져 있는 가로수의 위치가 주어질 때, 모든 가로수가 같은 간격이 되도록 새로 심어야 하는 가로수의 최소수를 구하는 프로그램을 작성하라.
 * 단, 추가되는 나무는 기존의 나무들 사이에만 심을 수 있다.
 * <p>
 * 입력
 * 첫째 줄에는 이미 심어져 있는 가로수의 수를 나타내는 하나의 정수 N이 주어진다(3 ≤ N ≤ 100,000).
 * 둘째 줄부터 N개의 줄에는 각 줄마다 심어져 있는 가로수의 위치가 양의 정수로 주어지며, 가로수의- 위치를 나타내는 정수는 1,000,000,000 이하이다.
 * 가로수의 위치를 나타내는 정수는 모두 다르고, N개의 가로수는 기준점으로부터 떨어진 거리가 가까운 순서대로 주어진다.
 * <p>
 * 출력
 * 모든 가로수가 같은 간격이 되도록 새로 심어야 하는 가로수의 최소수를 첫 번째 줄에 출력한다.
 */

/**
 * 개선 사항
 * 각 가로수 사이의 거리값을 최대공약수를 나누어 계산할 필요 없이
 * 처음 가로수와 마지막 가로수 사이의 거리를 최대공약수로 나눈 후
 * 이미 심어져 있는 나무의 개수를 빼주면 된다
 */
public class Q2485 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] trees = new long[N];
        long[] distances = new long[N - 1];

        // 이전 가로수 위치 값 저장하여 가로수 간의 거리값 계산
        trees[0] = Long.parseLong(br.readLine());
        for (int i = 1; i < N; i++) {
            trees[i] = Long.parseLong(br.readLine());
            distances[i - 1] = trees[i] - trees[i - 1];
        }

        /**
         * 두 거리 간의 최대공약수를 구한 후 다음 거리와 비교하여 최대공약수 계산
         * 계산한 최대공약수와 다음 거리 간의 최대공약수 계산
         */
        long gcd = gcd(distances[1], distances[0]);
        for (int i = 2; i < N - 1; i++) {
            gcd = gcd(distances[i], gcd);
        }

        /**
         *  전체 가로수 사이의 간격 계산하여 gcd로 나누어준 후 +1 하여 총 가로수 개수 계산
         *  그 후 기존에 심어져있던 가로수 수(N)만큼 빼준다.
         */
        System.out.println((trees[N - 1] - trees[0]) / gcd + 1 - N);
    }

    public static long gcd(long A, long B) {

        long r = A % B;

        if (r == 0) {
            return B;
        }

        return gcd(B, r);
    }
}

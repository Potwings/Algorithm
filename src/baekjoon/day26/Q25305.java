package baekjoon.day26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에
 * N명의 학생들이 응시했다.
 * 이들 중 점수가 가장 높은
 * k명은 상을 받을 것이다. 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
 * 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.
 * <p>
 * 입력
 * 첫째 줄에는 응시자의 수 N과 상을 받는 사람의 수 k가 공백을 사이에 두고 주어진다.
 * 둘째 줄에는 각 학생의 점수 x가 공백을 사이에 두고 주어진다.
 * <p>
 * 출력
 * 상을 받는 커트라인을 출력하라.
 */
public class Q25305 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        // 점수들을 정렬 내림차순으로 정렬 후 배열에서 k-1 인덱스값이 커트라인이 된다.
        /**
         * 선택 정렬을 안써봐서 선택 정렬 이용하여 정렬
         * 다만 여기서는 내림차순으로 정렬하므로 최솟값 대신 최댓값을 이용하여 정렬한다.
         * 1. 배열에서 최댓값의 인덱스를 찾는다.
         * 2. 최대값을 첫번째 인덱스와 위치를 바꾼다.
         * 3. 첫번째 인덱스를 제외하고 나머지 부분에서 최댓값의 인덱스를 찾아 1,2 번을 반복한다.
         */
        for (int i = 0; i < N; i++) {
            int maxIdx = i;
            for(int j = i; j < N; j++){
                if(scores[maxIdx] < scores[j]){
                    maxIdx = j;
                }
            }
            int maxValue = 0;
            maxValue = scores[maxIdx];
            scores[maxIdx] = scores[i];
            scores[i] = maxValue;
        }

        System.out.println(scores[k-1]);
    }
}

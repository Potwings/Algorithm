package baekjoon.day1to100.day10to50.day36;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제
 * 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
 * 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
 * (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 * <p>
 * 출력
 * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 */

/**
 * 개선 사항
 * 이차원 배열을 사용하였으나 시간 초과로 실패
 * <p>
 * 다른 사람들은 Comparator를 사용하여 해결했는데 비교 연산자에 대해 추가 학습할 것
 */
public class Q11650 {

        public static void main(String[] args) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[][] pointArr = new int[N][2];

            StringTokenizer st = null;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                pointArr[i][0] = Integer.parseInt(st.nextToken());
                pointArr[i][1] = Integer.parseInt(st.nextToken());
            }

            // 첫번째 값이 동일한 경우 두번쨰 값과 비교하여 정렬
            Arrays.sort(pointArr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

            StringBuffer sb = new StringBuffer();
            for (int[] point : pointArr) {
                sb.append(point[0]).append(" ").append(point[1]).append("\n");
            }

            System.out.println(sb.toString());
        }
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        Map<Integer, List<Integer>> pointMap = new HashMap<>();
//        StringTokenizer st = null;
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken());
//            int y = Integer.parseInt(st.nextToken());
//            if (pointMap.containsKey(x)) {
//                // 이미 x가 Map에 등록되어 있을 경우 리스트에 y만 추가해준다.
//                pointMap.get(x).add(y);
//                continue;
//            }
//
//            List<Integer> yList = new ArrayList<>();
//            yList.add(y);
//            pointMap.put(x, yList);
//        }
//
//        // x좌표 기준으로 정렬
//        Integer[] keySet = pointMap.keySet().toArray(new Integer[0]);
//        Arrays.sort(keySet);
//
//        StringBuilder sb = new StringBuilder();
//        for (Integer x : keySet) {
//            List<Integer> yList = pointMap.get(x);
//            // x좌표값이 동일할 경우 y좌표 기준으로 정렬
//            Collections.sort(yList);
//            for (int y : yList) {
//                sb.append(x).append(" ").append(y).append("\n");
//            }
//        }
//
//        System.out.println(sb.toString());
//    }
}
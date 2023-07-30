package baekjoon.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q3009 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 하나의 x,y좌표의 값은 모든 점에서 총 2번씩 사용되어야 축에 평행한 직사각형이 된다.
        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();

        for (int i = 0; i < 3; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            checkNeedPoint(xSet, x);
            checkNeedPoint(ySet, y);
        }

        // set에 남아있는 int값이 x,y좌표인 점을 추가해주어야한다.
        StringBuffer sb = new StringBuffer();
        sb.append(xSet.iterator().next());
        sb.append(" ");
        sb.append(ySet.iterator().next());

        System.out.println(sb.toString());
    }

    public static void checkNeedPoint (Set set, int point){

        if(set.contains(point)){
            // 해당 좌표의 점이 두 개 있을 경우 새로 추가할 필요 없으므로 제거
            set.remove(point);
        }else {
            // 해당 좌표의 점이 없을 경우 추가
            set.add(point);
        }
    }
}

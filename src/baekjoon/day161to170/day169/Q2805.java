package baekjoon.day161to170.day169;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항 결과값 배열을 모두 구해놓을 필요 없이 이분 탐색 중 구하여 비교 진행하면 된다.
 * 목표값(M)은 int 범위 이내이지만 결과값은 int 범위를 초과할 수 있다.
 */
public class Q2805 {

  // 클래스 변수
  // 전체 나무 길이 배열 선언
  static int[] trees;

  // 메인
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 전체 나무 개수 입력
    int N = Integer.parseInt(st.nextToken());
    // 필요한 나무 길이 입력
    int M = Integer.parseInt(st.nextToken());

    // 파라미터 최대값을 위한 나무 최대값 저장
    int max = 0;
    // 최대값 확인하며 전체 나무 길이 배열 저장
    st = new StringTokenizer(br.readLine());
    trees = new int[N];
    for (int i = 0; i < N; i++) {
      int tree = Integer.parseInt(st.nextToken());
      trees[i] = tree;
      if (tree > max) {
        max = tree;
      }
    }

    /*
     이분 탐색을 통하여 결과값이 M일 경우의 인덱스를 확인

     start가 end보다 커지는 경우 M이 결과값에 존재하지 않는 경우다.
     이떄 절단기의 높이가 end일 때의 값이 M보다 큰 결과값이 나오는 경우 중 최소인 경우다.
     */
    int start = 0;
    int end = max;
    while (start <= end) {
      int now = (start + end) / 2;
      long result = getResult(now);
      if (result > M) {
        start = now + 1;
      } else if (result < M) {
        end = now - 1;
      } else {
        // 결과값이 목표값과 일치할 경우 해당 인덱스를 end로 설정하고 반복 종료한다.
        end = now;
        break;
      }
    }
    // 결과값 배열의 인덱스가 절단기에 설정할 수 있는 높이의 최대값이다.
    System.out.println(end);
  }

  // 결과값 생성 메소드(param - int, return - int)
  public static long getResult(int height) {
    long result = 0;
    // 나무가 param값보다 클 경우 나무길이 - param 값 하여 결과값에 합한다.
    for (int tree : trees) {
      if (tree > height) {
        result += tree - height;
      }
    }
    return result;
  }
}

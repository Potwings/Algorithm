package baekjoon.day101to200.day101to110.day109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 개선 사항
 * Map의 getOrDefault 메소드를 사용하면 좀 더 간결하게 표현할 수 있음
 * getOrDefault -> return (((v = get(key)) != null) || containsKey(key)) ? v : defaultValue; 으로 내부 동작
 *
 * 키 값에 대한 정렬이 필요할 것으로 생각하였으나
 * 키의 값이 너무 단순하여 HashMap에서 자동으로 정렬해준다 한다. TODO 추가적인 내용 정리 필요
 */
public class Q1159 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> nameMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Character firstName = br.readLine().charAt(0);
            nameMap.put(firstName, nameMap.getOrDefault(firstName, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Character key : nameMap.keySet()) {
            if (nameMap.get(key) >= 5) {
                sb.append(key);
            }
        }

        if (sb.length() > 0) {
            System.out.println(sb);
        } else {
            System.out.println("PREDAJA");
        }
    }
}

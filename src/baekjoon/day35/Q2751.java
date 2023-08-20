package baekjoon.day35;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2751 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        for(int num : nums) {
            sb.append(num).append("\n");
        }

        System.out.println(sb.toString());
    }
}

package baekjoon.day61;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q3052 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> intSet = new HashSet<>();
        for(int i = 0; i < 10; i++){
            int num = Integer.parseInt(br.readLine());
            intSet.add(num % 42);
        }

        System.out.println(intSet.size());
    }
}

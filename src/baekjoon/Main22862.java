package baekjoon;

import java.util.*;
import java.io.*;

public class Main22862 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int a = 0; a < N; a++) {
            arr[a] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        int oddCount = 0;
        int maxEvenLength = 0;

        while (right < N) {
            // 홀수면 삭제 카운트 증가
            if (arr[right] % 2 != 0) {
                oddCount++;
            }

            // 조건 초과 시 왼쪽 포인터 이동
            while (oddCount > K) {
                if (arr[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }

            // 현재 구간에서 짝수 개수 = 전체 길이 - 홀수 개수
            maxEvenLength = Math.max(maxEvenLength, right - left + 1 - oddCount);
            right++;
        }

        System.out.println(maxEvenLength);
    }
}

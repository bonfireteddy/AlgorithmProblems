package baekjoon;

import java.util.*;
import java.io.*;

public class Main1749 {
	
	// 방법 1. 완전탐색 + 2차원 배열 누적합
	// 방법 2. 2차원 배열 1차원 압축 + 카데인 알고리즘(연속된 부분 수열 최대 합)
	// 연속되는게 중요한거고 2차원 배열에 있는 연속된 각 요소를
	// 누적합으로 묶어서 1차원 배열로 압축해두면 카데인 알고리즘으로 
	// 연속된 행중에서 각 요소요소들을 하나씩 전부 비교해 갈 수 있는거구나! 
	// 그리고 남은건 left랑 right를 조회하는데, 모든 경우의 수가 나올 수 있도록 
	// 조회해주기만 하면 된다.
	
	public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열

        int[][] arr = new int[N + 1][M + 1]; // 원본 배열
        int[][] prefix = new int[N + 1][M + 1]; // 2차원 누적합 배열

        // 배열 입력 및 누적합 계산
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                prefix[i][j] = prefix[i][j - 1] + arr[i][j]; // 행별 누적합
            }
        }

        int max = Integer.MIN_VALUE;

        // 열 구간 고정
        for (int left = 1; left <= M; left++) {
            for (int right = left; right <= M; right++) {
                // 행별 left~right 열 구간 합을 빠르게 계산하기 위해 prefix 사용
                int[] temp = new int[N + 1];

                for (int row = 1; row <= N; row++) {
                    temp[row] = prefix[row][right] - prefix[row][left - 1];
                }

                // Kadane 알고리즘 (1차원 최대 연속합)
                int sum = 0;
                for (int i = 1; i <= N; i++) {
                    sum = Math.max(temp[i], sum + temp[i]);
                    max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }
}

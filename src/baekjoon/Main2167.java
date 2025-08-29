package baekjoon;

import java.util.*;
import java.io.*;

public class Main2167 {
	
	// 2차원 배열에서의 누적합 구하기
	// 2차원 배열이 주어졌을때 K개의 구간이 주어지고 K개의 구간의 합을 출력하는 문제
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][M+1];
		int[][] sumArr = new int[N+1][M+1]; // 구간합 배열
		
		for(int a = 1; a <= N; a++) {
			st = new StringTokenizer(br.readLine());
			for(int b = 1; b <= M; b++) {
				arr[a][b] = Integer.parseInt(st.nextToken());
				
				sumArr[a][b] = arr[a][b] 
							+sumArr[a-1][b] // 위쪽
							+sumArr[a][b-1] // 왼쪽
							-sumArr[a-1][b-1]; // 겹치는 부분
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		
		for(int a = 0; a < K; a++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int answer = sumArr[x][y] 
						-sumArr[i-1][y] // 위쪽
						-sumArr[x][j-1] // 왼쪽
						+sumArr[i-1][j-1]; // 겹치는 부분
			
			sb.append(answer).append('\n');					
		}
		
		
		System.out.println(sb.toString());
	}

}

package baekjoon;

import java.util.*;
import java.io.*;

public class Main15724 {
	
	// 전형적인 2차원 배열 누적합 문제
	// 2차원 배열 누적합 공식  
	// =>현재값의 바로 위 좌표 누적합 + 현재값의 왼쪽 좌표 누적합 + 현재값 - 현재값의 좌대각 좌표 누적합 
	// 2차원 배열 구간합 공식
	// => x2, y2 누적합 - 직사각형 영역 왼쪽 누적합 - 직사각형 영역 위쪽 누적합 +  x1,y1의 좌대각 좌표 누적합
	// 위 2개 공식 가지고 풀면된다.
	// StringBuilder에 출력 전부 더한다음 한꺼번에 출력하는 걸로 시도해보자.
	// 누적합하면 시간복잡도가 O(1)로 상수시간이니까 통과하는거 맞겠지?
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][M+1]; // 1-based
		int[][] prefix = new int[N+1][M+1]; // 1-based
		
		for(int a = 1; a <= N; a++) {
			st = new StringTokenizer(br.readLine());
			for(int b = 1; b <= M; b++) {
				int current = Integer.parseInt(st.nextToken());
				arr[a][b] = current;
				prefix[a][b] = prefix[a-1][b]+prefix[a][b-1]-prefix[a-1][b-1]+current;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		
		for(int a = 1; a <= K; a++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int resultSum = prefix[x2][y2]-prefix[x2][y1-1]-prefix[x1-1][y2]+prefix[x1-1][y1-1];
			
			sb.append(resultSum + "\n");
		}
		
		
		System.out.print(sb);
	}

}













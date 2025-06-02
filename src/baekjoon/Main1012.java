package baekjoon;

import java.util.*;
import java.io.*;

public class Main1012 {
	
	// 전형적인 DFS문제 1을 만나면 DFS시작하고 상하좌우로 탐색하면서
	// visited를 true로 채워나간다. 그렇게 DFS를 다 끝내면 result에 1씩 더하면서
	// 진행하면 된다.
	
	static int[][] arr;
	static boolean visited[][];
	static int N;
	static int M;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int result = 0;
			
			arr = new int[N][M];
			visited = new boolean[N][M];
			
			// 2차원 배열, 방문기록 초기화
			for(int a = 0; a < N; a++) {
				for(int b = 0; b < M; b++) {
					arr[a][b] = 0;
					visited[a][b] = false;
				}
				
			}
			
			// 배추 심어놓은 곳 초기화
			for(int a = 0; a < K; a++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = 1;
			}
			
			// 모든 칸 순회하면서 DFS
			for(int a = 0; a < N; a++) {
				for(int b = 0; b < M; b++) {
					// 좌표에 방문한 적이 없고 좌표에 배추가 심어져있는 경우
					if(!visited[a][b] && arr[a][b] == 1) {  
						dfs(a,b);
						result++;
					}
				}
			}
			
			System.out.println(result+" ");
		}
		
	}
	
	static void dfs(int a, int b) {
		visited[a][b] = true;
		
		int[] da = {-1,1,0,0};
		int[] db = {0,0,-1,1};
		
		int na;
		int nb;
		
		for(int i = 0; i < 4; i++) {
			na = da[i] + a;
			nb = db[i] + b;
			
			if(na >= 0 && na < N && nb >= 0 && nb < M && !visited[na][nb] && arr[a][b] == 1) {
				dfs(na, nb);
			}
		}
			
	}
	
}












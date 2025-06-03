package baekjoon;

import java.util.*;
import java.io.*;

public class Main10026 {
	
	static char[][] arr;
	static boolean visited[][];
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visited = new boolean[N][N];
		int result = 0;
		int result2 = 0;
		
		for(int a = 0; a < N; a++) {
			String line = br.readLine();
			for(int b = 0; b < N; b++) {
				arr[a][b] = line.charAt(b); // 배열 초기화
				visited[a][b] = false; // 방문기록 초기화
			}
		}
		
		for(int a = 0; a < N; a++) {
			for(int b = 0; b < N; b++) {
				if(!visited[a][b]) {
					dfs(a, b);
					result++;
				}
			}
		}
		
		visited = new boolean[N][N]; //방문기록 초기화
		
		for(int a = 0; a < N; a++) {
			for(int b = 0; b < N; b++) {
				if(!visited[a][b]) {
					dfs2(a, b);
					result2++;
				}
			}
		}
		
		System.out.println(result +" "+ result2);
	}
	
	static void dfs(int a, int b) {
		visited[a][b] = true;
		
		int da[] = {-1,1,0,0};
		int db[] = {0,0,-1,1};
		
		int na, nb;
		for(int i = 0; i < 4; i++) {
			na = da[i] + a;
			nb = db[i] + b;
			
			// 적록색약이 아닌 사람이 봤을 때의 구역
			if(na >= 0 && na < N && nb >= 0 && nb < N && !visited[na][nb] && arr[a][b] == arr[na][nb]) {
				dfs(na, nb);
			}
		}
	}
	static void dfs2(int a, int b) {
		visited[a][b] = true;
		
		int da[] = {-1,1,0,0};
		int db[] = {0,0,-1,1};
		
		int na, nb;
		for(int i = 0; i < 4; i++) {
			na = da[i] + a;
			nb = db[i] + b;
			
			// 적록색약인 사람이 봤을 때의 구역
			if(na >= 0 && na < N && nb >= 0 && nb < N && !visited[na][nb]) {
				if(arr[a][b] == arr[na][nb]){
					dfs2(na, nb);
				}else if(arr[a][b] == 'R' || arr[a][b] == 'G'){
					if(arr[na][nb] == 'R' || arr[na][nb] == 'G'){
						dfs2(na, nb);
					}
				}
			}
		}
	}
}















package swea;

import java.util.*;
import java.io.*;

public class Solution2814 {
	
	static List<Integer>[] adj;
	static boolean visited[];
	static int result;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			result = 1; // 최장거리는 노드 수 기준이기 때문에 1부터 시작
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 정점 개수
			int M = Integer.parseInt(st.nextToken()); // 간선 개수
			
			// 정점 번호가 1번부터 시작하기 때문에 인덱스 1부터 N까지 쓴다.
			adj = new ArrayList[N+1]; // 인접리스트 생성
			visited = new boolean[N+1]; // 방문 체크
			
			for(int a = 1; a <= N; a++) { // 정점별 초기화
				adj[a] = new ArrayList<>();
				visited[a] = false; // 방문기록 초기화 
			}
			
			for(int a = 0; a < M; a++) { // 간선(x, y) 추가
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); 
				int y = Integer.parseInt(st.nextToken());
				
				adj[x].add(y);
				adj[y].add(x);
			}
			
			dfs(1, 1);
			
			System.out.printf("#%d %d\n", t, result);
		}
	}
	
	// 백트레킹 사용해서 최장경로 찾기
	// 최장경로 조건이 DFS때렸을때, adj[a].get(b) ==
	// 아 혹시 최장경로값을 백트레킹하는건가?
	static void dfs(int start, int depth) {
		
		result = Math.max(result, depth); // 최장경로 갱신
		visited[start] = true;
		//System.out.println(start+" ");
		
		for(int a = 0; a < adj[start].size(); a++) {
			if(!visited[adj[start].get(a)]) {
				dfs(adj[start].get(a), depth+1);
			}
		}
		visited[start] = false;
	}
}







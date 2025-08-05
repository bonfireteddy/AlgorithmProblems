package baekjoon;

import java.util.*;
import java.io.*;

public class Main18352 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		List<Integer>[] adjList = new ArrayList[N + 1]; // 인접리스트
		
		for (int i = 0; i <= N; i++) {
		    adjList[i] = new ArrayList<>();
		}
		
		for(int a = 0; a < M; a++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adjList[A].add(B);
		}
		
		// 거리 정보 배열
		int[] distance = new int[N + 1];
		Arrays.fill(distance, -1); // 방문 안 한 곳은 -1
		distance[X] = 0; // 시작 도시는 거리 0
		
		// BFS
		Queue<Integer> q = new LinkedList<>();
		q.offer(X);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : adjList[cur]){
				if(distance[next] == -1) {
					distance[next] = distance[cur] + 1;
					q.offer(next);
				}
			}
		}
		
		// 거리 k인 도시 출력
		boolean found = false;
		for(int i = 1; i <= N; i++) {
			if(distance[i] == K) {
				System.out.println(i);
				found = true;
			}
		}
		
		if(!found) {
			System.out.println(-1);
		}
	}

}

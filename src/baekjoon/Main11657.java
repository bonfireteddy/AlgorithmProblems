package baekjoon;

import java.util.*;
import java.io.*;

public class Main11657 {
	
	static class Edge {
		int to; // 도착 정점
		int weight; // 가중치
		
		Edge(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Edge>[] adjList = new ArrayList[N];
		
		for(int a = 0; a < N; a++) {
			adjList[a] = new ArrayList<>();
		}
		
		for(int a = 0; a < M; a++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()); // 가중치
			
			adjList[A].add(new Edge(B,C)); // 도착 정점, 가중치 저장
		}
	}

}

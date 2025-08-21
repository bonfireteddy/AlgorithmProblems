package baekjoon;

import java.util.*;
import java.io.*;

public class Main1753 {
	
	static class Node{
		int end;
		int weight;
		
		Node(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호
		int[] distance = new int[V+1]; // 최대 정점의 개수 기준
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0; // 시작 정점 최단거리는 0
		
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
		pq.add(new Node(K, 0)); // 시작정점의 가중치는 0
		
		List<Node>[] adjList = new ArrayList[V+1]; // 인접 리스트 생성
		for(int a = 1; a <= V; a++) {
			adjList[a] = new ArrayList<>();
		}
		
		for(int a = 0; a < E; a++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[u].add(new Node(v, w));
		}
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int u = cur.end;
			int d = cur.weight;
			
			// 이미 더 짧은 거리로 처리된 경우 스킵
			if(distance[u] < d) continue;
			
			for(Node next : adjList[u]) {
				int v = next.end;
				int nd = d + next.weight;
				
				if(nd < distance[v]) {
					distance[v] = nd;
					pq.add(new Node(v, nd));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
		    if (distance[i] == Integer.MAX_VALUE) sb.append("INF\n");
		    else sb.append(distance[i]).append("\n");
		}
		System.out.print(sb);

	}

}

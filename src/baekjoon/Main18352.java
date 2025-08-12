package baekjoon;

import java.util.*;
import java.io.*;

public class Main18352 {
	
	static class Node{
		int num;
		int cost;
		
		Node(int n, int c){
			this.num = n;
			this.cost = c;
		}
	}
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
		Arrays.fill(distance, Integer.MAX_VALUE); // 방문 안 한 곳은 최대값
		distance[X] = 0; // 시작 도시는 거리 0
			
		// Dijkstra
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
		pq.add(new Node(X, 0));
		
		// 다익스트라 메인 루프
        while (!pq.isEmpty()) {
        	Node cur = pq.poll();
        	
        	int u = cur.num; 
			int d = cur.cost;
        	
        	if(d != distance[u]) continue; // 오래된 상태 스킵
        	if(d > K) break; // K를 초과하는 비용은 볼 필요가 없음
        	
        	for (int v : adjList[u]) {
                int nd = d + 1;              // 간선 비용이 1
                if (nd < distance[v]) {
                	distance[v] = nd;
                    pq.add(new Node(v, nd));
                }
            }
        }
		
		// 거리 k인 도시 출력e
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

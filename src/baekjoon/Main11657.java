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
		
		int N = Integer.parseInt(st.nextToken()); // 정점(도시) 수: 1..N
		int M = Integer.parseInt(st.nextToken()); // 간선(버스) 수
		
		// ---- 인접 리스트 (1-based) ----
		List<Edge>[] adjList = new ArrayList[N + 1];
		
		for(int a = 1; a <= N; a++) {
			adjList[a] = new ArrayList<>();
		}
		
		for(int a = 0; a < M; a++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // from
			int B = Integer.parseInt(st.nextToken()); // to
			int C = Integer.parseInt(st.nextToken()); // 가중치
			
			adjList[A].add(new Edge(B,C)); // 도착 정점, 가중치 저장
		}
		
		// ---- 벨만–포드 ----
        final long INF = 987654321;
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0; // 시작 정점은 1번 도시

        // (N-1)번 완화
        for (int iter = 1; iter < N ; iter++) {
            boolean updated = false;

            // 모든 간선에 대해 완화 (인접 리스트를 통해 간선 열거)
            for (int u = 1; u <= N; u++) {
                if (dist[u] == INF) continue; // 아직 도달 못한 정점에서 나가는 간선은 무의미
                for (Edge e : adjList[u]) {
                    int v = e.to;
                    long w = e.weight;
                    long nd = dist[u] + w;
                    if (nd < dist[v]) {
                        dist[v] = nd;
                        updated = true;
                    }
                }
            }

            if (!updated) break; // 조기 종료(갱신 없으면 더 해도 의미 없음)
        }

        // 음수 사이클 검사: 한 번 더 완화해서 갱신이 일어나면 음수 사이클
        for (int u = 1; u <= N; u++) {
            if (dist[u] == INF) continue;
            for (Edge e : adjList[u]) {
                int v = e.to;
                long w = e.weight;
                if (dist[u] + w < dist[v]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        // 출력: 2번부터 N번까지 최단거리 (도달 불가면 -1)
        StringBuilder sb = new StringBuilder();
        for (int v = 2; v <= N; v++) {
            if (dist[v] == INF) sb.append(-1).append('\n');
            else sb.append(dist[v]).append('\n');
        }
        System.out.print(sb.toString());
		
	}

}

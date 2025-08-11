package baekjoon;

import java.io.*;
import java.util.*;

// 다익스트라 기법 활용
public class Main13549 {
	static final int MAX = 100_001;
	
	// 우선순위 큐에서 사용할 노드 정보
    static class Node {
        int pos; // 현재 위치 
        int cost; // 시작점에서 현재 위치까지 걸린 시간(비용)
        Node(int p, int c) { pos = p; cost = c; }
    }

    public static void main(String[] args) throws Exception {
    	
    	// 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 시작 위치
        int K = Integer.parseInt(st.nextToken()); // 목표 위치
        
        // 최단 시간 기록 배열 (dist[i] = N에서 i까지 가는 최소 시간)
        int[] dist = new int[MAX];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0; // 시작 위치는 0초
        
        // 우선순위 큐 (비용이 작은 순서로 꺼냄)
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(N, 0)); // 시작 위치 삽입
        
        
        // 다익스트라 메인 루프
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            // 이미 더 짧은 경로로 방문한 적이 있다면 스킵
            if (cur.cost > dist[cur.pos]) continue;
            
            // 목표 위치를 꺼낸 순간 최단 거리 확정 -> 종료
            if (cur.pos == K) break;

            // 가중치 0: 순간이동 0 비용: x -> 2x
            int nx = cur.pos * 2;
            if (nx < MAX && dist[nx] > cur.cost) {
                dist[nx] = cur.cost; // 비용 변화 없음
                pq.add(new Node(nx, cur.cost)); // 같은 비용으로 큐에 넣음 -> 우선순위 큐 상단에 가까움 
            }

            // 가중치 1: 걷기 1 비용: x-1, x+1
            for (int next : new int[]{cur.pos - 1, cur.pos + 1}) {
                if (0 <= next && next < MAX && dist[next] > cur.cost + 1) {
                    dist[next] = cur.cost + 1; // 비용 1 증가
                    pq.add(new Node(next, cur.cost + 1)); // 비용이 늘어나서 나중에 꺼내짐
                }
            }
        }

        System.out.println(dist[K]);
    }
}


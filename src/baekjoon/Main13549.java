package baekjoon;

import java.io.*;
import java.util.*;

public class Main13549 {
	static final int MAX = 100_001;

    static class Node {
        int pos, cost;
        Node(int p, int c) { pos = p; cost = c; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.pos]) continue;
            if (cur.pos == K) break; // 꺼낸 게 최단

            // 가중치 0: 순간이동
            int nx = cur.pos * 2;
            if (nx < MAX && dist[nx] > cur.cost) {
                dist[nx] = cur.cost;
                pq.add(new Node(nx, cur.cost));
            }

            // 가중치 1: 걷기
            for (int next : new int[]{cur.pos - 1, cur.pos + 1}) {
                if (0 <= next && next < MAX && dist[next] > cur.cost + 1) {
                    dist[next] = cur.cost + 1;
                    pq.add(new Node(next, cur.cost + 1));
                }
            }
        }

        System.out.println(dist[K]);
    }
}


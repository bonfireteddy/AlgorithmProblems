package baekjoon;

import java.io.*;
import java.util.*;

public class Main1325 {
    static int N, M;
    static List<Integer>[] graph;
    static int[] result;
    static int max;
    
    // BFS 함수: start에서 시작해서 몇 개를 해킹할 수 있는지 계산
    static void bfs() {
    	
    	 // 각 노드에서 BFS 수행
        max = 0;
        for (int start = 1; start <= N; start++) {
            
        	boolean[] visited = new boolean[N + 1];
            Queue<Integer> queue = new LinkedList<>();
            int count = 0; // 이 시작점에서 해킹할 수 있는 컴퓨터 수

            visited[start] = true;
            queue.add(start);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                count++; // 현재 컴퓨터도 해킹 가능하므로 카운트 증가
    						
    			// current가 해킹되면 다음에 해킹되는 컴퓨터들(next)을 탐색
                for (int next : graph[current]) { // 역방향 간선: current <-- next (여기서 graph[current]는 current를 신뢰하는 노드들)
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            
            result[start] = count;
            // start에서 시작해서 해킹할 수 있는 총 컴퓨터 수
            max = Math.max(max, result[start]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노드 수
        M = Integer.parseInt(st.nextToken()); // 간선 수

        graph = new ArrayList[N + 1];
        result = new int[N + 1];

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 (B를 해킹하면 A도 가능하므로 B → A 방향으로 저장)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[B].add(A); // 역방향 저장이 핵심
        }
        
        bfs();

        // 최댓값 갖는 노드 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}

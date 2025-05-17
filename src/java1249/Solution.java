package java1249;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	
	// BFS는 최단경로 확인 가능 
	// 근데 BFS는 가중치가 모두 같을때 최단 경로가 가능하다는데
	// 이 문제에서 구간을 통과할때마다 각각 다른 값이 주어지고 이
	// 값들 중에 가장 작은걸 구하는건데 여기서 이 값이 가중치인가?
	// 그럼 BFS로는 해결하기 힘든건가? O
	// 다익스트라로 문제를 해결해야한다.
	// 애초에 0,1이 지나갈 수 있냐 없냐를 뜻하는게 아님
	
	static int N;
	static int arr[][];
	
	// 상, 하, 좌, 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Node implements Comparable<Node> {
		
		int x, y, cost;
		
		Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			
			// 비용이 낮은 것이 우선
			// a < b → 음수 반환 (즉, a가 먼저)
			// a == b → 0 반환
			// a > b → 양수 반환 (즉, b가 먼저)
			
			// 만약 비용이 높은 걸 우선하려면
			// Integer.compare(o.cost, this.cost); 순서 반대
			
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static int dijkstra() {
		
		// Node를 담는 우선순위 큐 선언.
		// Node클래스의 compareTo를 통해 cost가 작은 것부터 꺼내짐
		PriorityQueue<Node> pq = new PriorityQueue<>(); // 힙 생성
		int[][] dist = new int[N][N]; // 최소누적비용 저장
		// dist[i][j]는 (i,j)까지 가는 현재까지 발견된 최단 비용.
		
		// dist 배열을 초기화
		// 모든 위치의 비용을 무한대로 세팅하고, 탐색을 통해 작은 값으로 갱신 예정.
		for(int[] row : dist) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		
		// 시작점 (0,0)을 큐에 넣음. 비용은 시작 칸의 값 자체(arr[0][0]).
		// 시작 지점의 누적 비용을 dist에도 반영.
		pq.add(new Node(0, 0, arr[0][0]));
		dist[0][0] = arr[0][0];
		
		// 큐가 빌 때까지 계속 탐색.
		// 항상 현재까지 누적 비용이 가장 작은 노드부터 처리하게 됨. 
		while(!pq.isEmpty()) {
			// 우선순위 큐에서 하나 꺼냄. 이때 cost가 가장 작은 좌표가 선택됨.
			Node current = pq.poll();
			
			// 목적지에 도달했으면, 해당 비용이 최단 경로 비용이므로 바로 반환.
			if(current.x == N - 1 && current.y == N - 1) {
				return current.cost; // 도착지에 도달
			}
			
			// 4방향 탐색(상하좌우).
			for(int dir = 0; dir < 4; dir++) {
				int nx = current.x + dx[dir];
				int ny = current.y + dy[dir];
				
				// 맵의 범위를 벗어나지 않는지 확인
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					
					// 다음 좌표까지 이동 시의 누적 비용 계산
					int newCost = current.cost + arr[nx][ny];
					
					// 만약 지금까지 알고 있는 (nx, ny)까지의 비용보다
					// 이번 경로의 비용이 더 작다면 → 갱신
					// 새로운 비용을 dist에 저장하고, 우선순위 큐에 추가
					if(newCost < dist[nx][ny]) {
						dist[nx][ny] = newCost;
						pq.add(new Node(nx, ny, newCost));
					}
				}
			}
		}
		
		return -1; // 도달 불가능한 경우
	}
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			int result = 0;
			
			arr = new int[N][N];
			
			for(int a = 0; a < N; a++) {
				String line = br.readLine();
				for(int b = 0; b < N; b++) {
					arr[a][b] = line.charAt(b) - '0';
				}
			}
			
			result = dijkstra();
			
			System.out.printf("#%d %d\n", t, result);
		}
	}
}

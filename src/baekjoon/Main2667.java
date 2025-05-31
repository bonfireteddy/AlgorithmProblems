package baekjoon;

import java.util.*;
import java.io.*;

public class Main2667 {
	
	// 전형적인 DFS문제
	// 이차원 배열 만들고 방문한 지점들 전부 visited에 넣는다.
	// 이 경우 다시 탐색할 필요가 없기 때문에 백트레킹은 사용하지 않는다.
	// DFS를 시작하고부터 1식 더해가는데, 이건 인자로 넘겨주면서 해야함.
	// 그리고 탐색이 끝나면 단지수에 1을 더해주고 단지내 집의 수를 오름차순으로 정렬해야하기
	// 때문에 집의 수의 배열도 따로 만들어서 Arrays.sort해준다.
	// 다시 NxN배열을 탐색하다가 visited가 false인 1을 만나면 DFS로 진입해준다.
	// 이렇게 반복해주면 완성~
	
	static int N;
	static int[][] arr;
	static int result;
	static boolean[][] visited;
	static List<Integer> list; // depth 저장용
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		result = 0;
		visited = new boolean[N][N];
		
		for (int a = 0; a < N; a++) {
			String line = br.readLine();
			for (int b = 0; b < N; b++) {
				arr[a][b] = line.charAt(b)-'0'; // 2차원 배열 초기화
				visited[a][b] = false; // 2차원 배열 방문기록 초기화
			}
		}
		
		list = new ArrayList<>();
		
		for (int a = 0; a < N; a++) {
			for (int b = 0; b < N; b++) {
				if(!visited[a][b] && arr[a][b] == 1) {
					int depth = dfs(a,b, 0);
					list.add(depth);
					result++;
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.printf("%d\n",result);
		for (int a = 0; a < list.size(); a++) {
			System.out.println(list.get(a));
		}
	}
	
	static int dfs(int a, int b, int depth) {
		visited[a][b] = true;
		depth++;
		
		int[] da = {-1,1,0,0};
		int[] db = {0,0,-1,1};
		
		int na, nb;
		for(int x = 0; x < 4; x++) { // 하상좌우 탐색
			na = da[x] + a; // 이동하는 새로운 a좌표
			nb = db[x] + b; // 이동하는 새로운 b좌표
			
			if(na >= 0 && na < N && nb >= 0 && nb < N && arr[na][nb] != 0 && !visited[na][nb]) {
				depth = dfs(na, nb, depth);
			}
		}
		return depth;
	}
}

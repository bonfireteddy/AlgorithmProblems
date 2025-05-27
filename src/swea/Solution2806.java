package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution2806 {
	
	// N*N보드에 N개의 퀸이 갈 수 있는 경로에 퀸이 겹쳐있지 않으면 된다.
	// 1번째 퀸이 0,0 자리에 놓고 1번째 퀸이 놓인 경로를 0으로 막아둔다.
	// 2번째 퀸이 들어갈 수 있는 자리에 놓고 2번째 퀸이 놓인 경로를 0으로 막아둔다.
	// 3번째 퀸이 들어갈 수 있는 자리가 없는 경우 2번째 퀸을 두기 전 상태로 돌아간다.
	// 이전에 2번째 퀸을 두었던 자리와 1번째 퀸의 경로를 제위한 다른 자리에 2번째 퀸을 둔다.
	// 다시 3번째 퀸이 들어갈 수 있는 자리가 있는지 탐색한다.
	// DFS, 백트래킹?
	
	static int[][] arr;
	static int result;
	static int temp;
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t < T; t++) {
			
			result = 0;
			
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			
			// 1은 갈 수 있는 경로, 0은 갈 수 없는 경로, 2는 퀸
			for(int a = 0; a < N; a++) {
				for(int b = 0; b < N; b++) {
					arr[a][b] = 1;
				}
			}
			
			dfs(0, 0);
			
			System.out.printf("#%d %d\n", t, result);
		}
	}
	
	// 어떻게 해서 경우의 수를 계산할건지 잘 생각해 봐야할 것 같음.
	static void dfs(int a, int b) {
		
		int da[] = {-1,-1,-1,0,1,1,1,0};
		int db[] = {-1,0,1,1,1,0,-1,-1};
		
		int[][] tmpArr = arr;
		
		for(int i = 0; i < 8; i++) { // 8뱡향 탐색
			
			int na = a;
			int nb = b;
			
			for(int j = 0; j < N-1; j++) {
				na += da[i];
				nb += db[i];
				
				if(tmpArr[na][nb] == 2) {
					// 2일 경우 퀸이 공격가능하기 때문에 arr[a][b]자리에는 둘 수 없음
					return; 
				}
				if(na < 0 || nb < 0 || na >= N || nb >= N) {
					break; // 1방향 진행 멈춤
				}
				if(tmpArr[na][nb] == 1) {
					tmpArr[na][nb] = 0;
				}
			}
		}
		
		
		arr = tmpArr; // 퀸이 겹치지 않은 경우 0으로 만들어준 부분을 원본 arr에 복사
		temp++;
		if(temp == N) {
			result++;
			temp--;
		}
		// 여기서 arr배열중에 남는 1골라서 dfs에 넣는 방식.
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 1) {
					dfs(i, j);
				}
			}
		}
	}

}

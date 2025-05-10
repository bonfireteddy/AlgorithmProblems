package java1226;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Point {
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {

	static int arr[][];
	static boolean visited[][];
	static int start = 2;
	static int end = 3;
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine());
			
			arr = new int[16][16];
			visited = new boolean[16][16];
			int result = 0;
			Point point = new Point(0,0);
			
			// 공백이 없을 때는 StringTokenizer보다 charAt이 유리하다 
			for(int a = 0; a < arr.length; a++) {
				String line = br.readLine(); // 한 줄씩 입력

				for(int b = 0; b < arr.length; b++) {
					arr[a][b] = line.charAt(b)-'0';
					// 문자를 정수로 변환해서 저장
				}
			}
			
			// 출발점 2찾기
			for(int a = 0; a < arr.length; a++) {
				for(int b = 0; b < arr.length; b++) {
					if(arr[a][b] == 2) {
						point.x = a;
						point.y = b;
					}
				}
			}
			
			//dfs로 도착지점 찾기
			result = dfs(point);
			
			System.out.printf("#%d %d\n", T, result);
		}

	}
	
	// 진행하다가 1만나면 0이 있는 다른 방향으로 가면 되는데
	// dfs로 하는거면 방향전환 기준이 뭘까?
	public static int dfs(Point point) {
		
		// x,y 기준으로 상하좌우 요소가 1인지 0인지 확인
		// 0인쪽으로 x,y를 갱신해 나가면서 분기점 발견
		// 분기점 좌표 기억해놓고 상하좌우 순서로 탐색
		// 근데 이 분기점 좌표를 여러개 저장을 해놓아야함.
		// 그리고 탐색이 끝나면 마지막에 저장해놨던 가장 최근 분기점으로 
		// 돌아가서 다른 경로를 탐색한다.
		
		// x, y기준으로 상하좌우 계산하는 좌표가 뭘까?
		// 방문 기록 저장
		visited[point.x][point.y] = true;
		// 종료 조건 - 도착지점 3 발견
		if (arr[point.x][point.y] == 3) {
			return 1;
		}
		
		if(!visited[point.x][point.y+1] && arr[point.x][point.y+1] == 0) {
			dfs(new Point(point.x, point.y+1));
		} 
		if(!visited[point.x][point.y-1] &&arr[point.x][point.y-1] == 0) {
			dfs(new Point(point.x, point.y-1));
		} 
		if(!visited[point.x-1][point.y] &&arr[point.x-1][point.y] == 0) {
			dfs(new Point(point.x-1, point.y));
		} 
		if(!visited[point.x+1][point.y] &&arr[point.x+1][point.y] == 0) {
			dfs(new Point(point.x+1, point.y));
		}
		
		// 종료 조건 - 도착지점 발견 X
		return 0;
	}
}

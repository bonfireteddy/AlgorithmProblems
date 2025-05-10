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
	
	
	public static int dfs(Point point) {
		
		// 방문 기록 저장
		visited[point.x][point.y] = true;
		
		// 종료 조건 - 도착지점 3 발견
		if (arr[point.x][point.y] == 3) {
			return 1;
		}
		
		int[] dx = {0,0,1,-1}; // 좌우
		int[] dy = {1,-1,0,0}; // 상하
		
		for(int a = 0; a < 4; a++) { // 상하우좌 순으로 탐색
			int nx = point.x + dx[a];
			int ny = point.y + dy[a];
			
			if (nx >= 0 && ny >= 0 && nx < 16 && ny < 16) {
				if(!visited[nx][ny] && arr[nx][ny] != 1) {
					if(dfs(new Point(nx, ny)) == 1) {
						return 1;
					}
				}
			}
		}
		
		// 종료 조건 - 도착지점 발견 X
		return 0;
	}
}

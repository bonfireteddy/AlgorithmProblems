package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1220{
	
	// 그냥 횟수만 세면 되기 때문에 모양을 만들 필요는 없음
	// 세로로 탐색하다가 1,2중 하나만 있는 경우 
	// 1이면 아래에 아무것도 없는경우 그냥 넘어감, 2이면 위에 아무것도 없는경우 그냥 넘어감
	// 1아래에 2가 있으면 교착상태, 2위에 1이 있으면 교착상태
	// 한번 교착상태가 만들어지면 그 다음 인덱스부터 확인하면 된다.
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			int[][] arr = new int[N][N];
			
			for(int a = 0; a < N; a++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int b = 0; b < N; b++) {
					arr[a][b] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int a = 0; a < N; a++) { // 가로
				int current = 0;
				int next = 0;
				for(int b = 0; b < N; b++) { // 세로
					if(current == 0) {
						if(arr[b][a] == 1) {
							// 아래에 뭐가 있어야 +
							current = arr[b][a];
						}
						if(arr[b][a] == 2) {
							// 위에 뭐가 있어야 +
							current = 0;
						}
					} else if(current == 1 && arr[b][a] == 2) {
						result++;
						current = 0;
					} else if(current == 2 && arr[b][a] == 1) {
						current = 1;
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, result);
		}
	}
}
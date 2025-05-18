package java1979;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	// 이차원 배열 만들고 2중 for문 돌면서
	// arr[i][j]에 1이 정확하게 k번 나오고 다음 수가 0이거나
	// 마지막으로 1이나온자리가 N-1일 경우에만 result에 1씩 추가
	
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			
			for(int a = 0; a < N; a++){
				st = new StringTokenizer(br.readLine());
				for(int b = 0; b < N; b++){
					arr[a][b] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 가로 탐색
			for(int a = 0; a < N; a++){
				int n = 0;
				for(int b = 0; b < N; b++){
					if(arr[a][b] == 1) {
						n++;
					} else  { // 현재 0이고 n이 3인 경우
						if(n == K) {
							result++;
						}
						n = 0;
					}
				}
				if (n == K) { // 끝까지 탐색하고 3인 경우 - 끝자락이 1인 경우
					result++;
	            }
			}
			
			// 세로 탐색
			for(int a = 0; a < N; a++){
				int n = 0;
				for(int b = 0; b < N; b++){
					if(n == K && arr[b][a] == 0){ // 뒤에 0이 나오는 경우
						result++;
						n = 0;
					}
					if(arr[b][a] == 1) {
						n++;
					} else if(arr[b][a] == 0) {
						n = 0;
					}
					// 3이 된 순간 추가하는게 아니라 이게 마지막 이거나
					// 뒤에 0이 나오는 경우에 +1
					// 그렇게 하면 1이 K를 넘는경우에도 더해버려서 안됨.
					 
					if(n == K && b == N-1){ // 이게 마지막 요소인 경우
						result++;
						n = 0;
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, result);
		}
		
		
	}

}

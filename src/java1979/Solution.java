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
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t < T; t++) {
			
			System.setIn(new FileInputStream("res/input.txt"));
			int result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			
			for(int a = 0; a < T; a++){
				st = new StringTokenizer(br.readLine());
				for(int b = 0; b < T; b++){
					arr[a][b] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int a = 0; a < T; a++){
				for(int b = 0; b < T; b++){
					if(arr[a][b] == 0) {
						
					} else {
						
					}
					
				}
			}
			
			System.out.printf("#%d %d", t, result);
		}
		
		
	}

}

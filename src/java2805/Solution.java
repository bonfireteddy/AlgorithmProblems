package java2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	// 이차원 배열의 크기가 정해진다.
	// 모서리쪽을 전체에서 빼야하나...하다가 
	// 가운데 행은 전부 다 탐색 대상이다. 근데 가운데 행은 N개
	// 따라서 가운데 행 기준으로 위로 아래로 양쪽에서 하나씩 탐색대상 줄이면서
	// 올라가고 내려가면서 더하면 끝?
	
	static int arr[][];
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			
			for(int a = 0; a < N; a++) {
				String line = br.readLine();
				for(int b = 0; b < N; b++) {
					arr[a][b] = line.charAt(b)-'0';
				}
			}
			
			int result = 0;
			int middle = N/2;
			
			// 중간부터 위로 찾기
			for(int a = middle, t = 0;  a >= 0; a--, t++) {
				for(int b = t; b < N-t; b++) {
					result += arr[a][b];
				}
			}
			
			// 중간제외 아래 찾기
			for(int a = middle+1, t = 1; a < N; a++, t++) {
				for(int b = t; b < N - t; b++) {
					result += arr[a][b];
				}
			}
			
			System.out.printf("#%d %d\n", test_case, result);
		}

	}

}

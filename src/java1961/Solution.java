package java1961;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	// 2차원 배열, 90도는 원래 배열의 맨 아래줄이 a 왼쪽줄이 b
	// 180도는 원래 배열의 (2, 2) 맨 오른쪽줄이 a, 맨 아래줄이 b
	// 270도는 맨 위줄이 a, 맨 오른쪽줄이 b
	// b줄에 있는 요소만 순서대로 StringBuilder로 append하면서 
	// 합쳐진 요소들을 a줄에 90도는 0+n, 180도는 1+n, 270도는 2+n;
	
	static String[][] arr;
	static String[][] resultArr;
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			arr = new String[N][N];
			resultArr = new String[N][N];
			
			for(int a = 0; a < N; a++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int b = 0; b < N; b++) {
					arr[a][b] = st.nextToken();
				}
			}
			
			// 90도 계산
			for(int a = 0; a < N; a++) {
				StringBuilder sb = new StringBuilder();
				for(int b = N-1; b >= 0; b--) {
					sb.append(arr[N-1][a]);
				}
				
				//출력할 배열에 저장
				for(int i = 0; i < N; i++) {
					resultArr[i][0] = sb.toString();
				}
			}
			
//			// 180도 계산
//			for(int a = 0; a < N; a++) {
//				StringBuilder sb = new StringBuilder();
//				for(int b = N-1; b >= 0; b--) {
//					sb.append(arr[N-1][a]);
//				}
//				
//				//출력할 배열에 저장
//				for(int i = 0; i < N; i++) {
//					resultArr[i][0] = sb.toString();
//				}
//			}
//			
//			// 270도 계산
//			for(int a = 0; a < N; a++) {
//				StringBuilder sb = new StringBuilder();
//				for(int b = N-1; b >= 0; b--) {
//					sb.append(arr[N-1][a]);
//				}
//				
//				//출력할 배열에 저장
//				for(int i = 0; i < N; i++) {
//					resultArr[i][0] = sb.toString();
//				}
//			}
			
			System.out.printf("#%d\n", test_case);
			
			for(int a = 0; a < N; a++) {
				for(int b = 0; b < N; b++) {
					System.out.print(resultArr[a][b]+" ");
				}
				System.out.println();
			}
			
			
		}

	}

}

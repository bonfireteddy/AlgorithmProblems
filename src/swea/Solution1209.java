package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1209 {
	
	// 배열에서 오름차순 정렬 코드 다시보기
	
	// maxValue하나 두고 교체해나가면서 최대값 찾기
	static int arr[][];
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			
			int result = 0;
			int T = Integer.parseInt(br.readLine());
			arr = new int[100][100];
			
			for(int a = 0; a < 100; a++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int b = 0; b < 100; b++) {
					arr[a][b] = Integer.parseInt(st.nextToken());
				}
			}
			
			int sum = 0;
			
			// 각 행의 합 구하기
			for(int a = 0; a < 100; a++) {
				for(int b = 0; b < 100; b++) {
					sum += arr[a][b];
				}
				result = Math.max(result, sum);
				sum = 0;
			}
			
			// 각 열의 합 구하기
			for(int a = 0; a < 100; a++) {
				for(int b = 0; b < 100; b++) {
					sum += arr[b][a];
				}
				result = Math.max(result, sum);
				sum = 0;
			}
			
			// 각 대각선의 합 구하기
			for(int a = 0; a < 100; a++) { // 왼쪽 대각선
				sum += arr[a][99-a];
				
			}
			result = Math.max(result, sum);
			sum = 0;
			for(int b = 0; b < 100; b++) { // 오른쪽 대각선
				sum += arr[b][b];
			}
			result = Math.max(result, sum);
			sum = 0;
			
			System.out.printf("#%d %d\n", test_case, result);
		}
		
		
		
	}

}

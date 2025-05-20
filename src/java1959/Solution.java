package java1959;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	// 배열 2개 만들고 비어있는 부분을 어떻게 처리해야할까..
	// 0을 넣는건 안된다. 음수를 넣는것도 안된다.
	// 자바는 null체크도 안되는걸로 알고 있는데.
	// 일단 A배열이 길 수도 있고 B배열이 길 수도 있다.
	// 마주보는 숫자들만 계산하는 것이기 때문에 더 짧은 배열 인덱스 기준으로 자르면 되는구나
	// 아니 근데 이건 input자체가 아무것도 안넣는 테스트케이스가 없는데?
	// 아... 이럴수다 마주보는 숫자들을 곱한 뒤 모두 더할 때 최댓값을 구하는것이구나..
	// 
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int N = 0;
			int M = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int a = 0; a < N; a++) {
				A[a] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int a = 0; a < M; a++) {
				B[a] = Integer.parseInt(st.nextToken());
			}
			
			// 모든 경우의 수 개수 = 더 큰 갯수 - 작은 갯수 
			int result = Integer.MIN_VALUE;

			if (N <= M) {
				for (int i = 0; i <= M - N; i++) {
					int sum = 0;
					for (int j = 0; j < N; j++) {
						sum += A[j] * B[i + j];
					}
					result = Math.max(result, sum);
				}
			} else {
				for (int i = 0; i <= N - M; i++) {
					int sum = 0;
					for (int j = 0; j < M; j++) {
						sum += A[i + j] * B[j];
					}
					result = Math.max(result, sum);
				}
			}
			
			System.out.printf("#%d %d\n", t, result);
		}

	}

}

package java1226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	// DFS로 풀 수 있는 문제라고 하는데
	// 근데 일단 문제만 봐서는 DFS로 풀지 BFS로 풀지 감이 안옴
	//

	static int arr[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine());
			
			//공백없는 걸 하나씩 받는게 뭐였더라?
			
			int result = 0;
			
			for(int a = 0; a < arr.length; a++) {
				
			}
			
			System.out.printf("#%d %d\n", T, result);
		}

	}

	public static void dfs(int x, int y) {

		dfs(x, y);

		// 종료 조건
		if (arr[x][y] == 3) {
			
		}
	}
}

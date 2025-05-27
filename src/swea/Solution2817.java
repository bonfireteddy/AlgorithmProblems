package swea;

import java.util.*;
import java.io.*;

public class Solution2817 {
	
	// N개의 자연수 -> 최소 1개이상 수를 선택 -> 그 합이 K가 되는 경우의 수
	// ex) 4개의 자연수 1 2 1 2중에서 최소 1개 이상 수를 선택하고 그 합이 3이 되는 경우의 수 -> 4
	// 1개 선택, 2개 선택, 3개선택, 4개선택 을 모두 고려해야한다.
	// 이거 백트레킹 맞나? 조합문제 아닌가? 아닌가 조합문제가 어떻게 보면 백트레킹이라고도 할 수 있는건가...
	//
	
	static int result;
	static int arr[];
	static int N;
	static int K;
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int a = 0; a < N; a++) {
				arr[a] = Integer.parseInt(st.nextToken());
			}
			
			// 길이가 1부터 N까지인 조합을 모두 출력
			for (int r = 1; r <= N; r++) {
	            dfs(0, 0, r, new ArrayList<>(), 0);
	        }
			
			System.out.printf("#%d %d\n", test_case, result);
		}
		
	}
	
	// start: 탐색 시작 인덱스
	// depth: 현재까지 선택한 개수
	// r: 목표로 하는 조합의 길이 
	static void dfs(int start, int depth, int r, List<Integer> comb, int sum) {
		if(sum > K) return; // 가지치기: 합이 이미 k를 넘으면 더 이상 탐색할 필요 없음
		
		if(depth == r) { // depth 시작이 0이기 때문에 r이랑 같다는게 목표 조합길이를 넘었다는 것.
			if(sum == K) {
				result++; // 합이 K일 때만 출력
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			comb.add(arr[i]);	// 원소 선택
			dfs(i + 1, depth + 1, r, comb, sum + arr[i]); // 다음 원소 선택(중복 없이, 순서 상관없음)
			comb.remove(comb.size()-1); // 백트래킹
		}
	}
}











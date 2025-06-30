package baekjoon;

import java.util.*;
import java.io.*;

public class Main2798 {
	
	// N장의 카드 중에서 3장을 뽑아서 M을 넘지 않으면서 M과 최대한 가깝게 만들어야한다.
	// N개의 숫자중에서 3개로 만들 수 있는 조합중에서 M을 넘지 않는 최대값을 구하면 된다.
	// 이거 조합문제로 볼 수도 있는데, DFS로 플수도 있을듯?
	// 근데 완전탐색은 시간복잡도 계산하는게 진짜 중요하다고 생각이 든다.
	// 시간복잡도를 알아야 이걸 완탐으로 풀지 다른 방식으로 해야할지 결정이 되기 때문
	// N이 100으로 작기때문에 N*N*N을 해도 1000000 백만 정도라 완탐 가능
	// N장의 카드 중에서 3장의 카드롤 고르는데 고른 카드의 합이 M을 넘지 않으면서 
	// M과 최대한 가깝게 만들 수 있는 카트 3장의 합.
	// 순서고려안하니까 조합, 중복허용x, 5C3중에서 최대합 구하면 됨.
	
	static int N;
	static int M;
	
	static int[] arr;
	static int max;
	
	public static void dfs(int start, int depth, int sum) {
		
		if(sum > M) return; // 백트레킹 조건 추가
		
		if(depth == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = start; i < N; i++) {
			dfs(i + 1, depth + 1, sum + arr[i]);
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int a = 0; a < N; a++) {
			arr[a] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,0);
		
		System.out.println(max);
	}
}

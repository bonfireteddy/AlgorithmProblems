package baekjoon;

import java.util.*;
import java.io.*;

public class Main1969 {
	
	// 이게 뭔소리지... 그니까 주어진 각 DNA들과의 글자가 다른 개수의 합이 
	// 최소가 되도록 하는 DNA를 구하는 것 같은데 이걸 어떻게 구하지?
	// A, T, G, C 4가지로 만들 수 있는 M개의 서로 다른 경우 
	// 즉, 순열 - 중복허용으로 만들 수 있는 DNA들을 입력으로 주어진 DNA들과 대조하면서
	// 다른 글자를 찾으면서 최소값을 갱신하면 될 것 같다.
	static int N;
	static int M;
	
	static char[] ncts = {'A','T','G','C'};
	static String[] dnaStr;
	static List<String> results = new ArrayList<>();
	static int sum = Integer.MAX_VALUE;
	
	static void dfs(int depth, String current) {
		if(depth == M) {
			// 여기서 각 DNA들이랑 다른 문자합계 구하고 sum에 넣고 return
			
			int count = 0;
			for(int a = 0; a < dnaStr.length; a++) {
				for(int b = 0; b < M; b++) {
					if(current.charAt(b) != dnaStr[a].charAt(b)) {
						count++;
					}
				}
				
			}
			
			if(sum > count) {
				sum = count;
				results.clear(); // 모든 요소 제거
				results.add(current);
				
			}else if(sum == count) {
				results.add(current);
			}
			
			return;
		}
		
		for(char c : ncts) {
			dfs(depth+1, current + c);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dnaStr = new String[N];
		
		for(int a = 0; a < N; a++) {
			String current = br.readLine();
			dnaStr[a] = current;
		}
		
		dfs(0, "");
		
		Collections.sort(results);
		
		System.out.println(results.get(0)); // 사전 순 정렬 첫번째 요소
		System.out.println(sum);
	}

}

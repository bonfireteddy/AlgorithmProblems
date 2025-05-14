package java5215;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Ingredient{
	
	int T; // 맛 점수
	int K; // 칼로리
	
	public Ingredient(int T, int K) {
		this.T = T;
		this.K = K;
	}
}

public class Solution {
	
	static List<Ingredient> list = new ArrayList<>();
	static List<Ingredient> combination = new ArrayList<>();
	static int result;
	static int N;
	static int L;
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int Test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= Test; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			list = new ArrayList<>();
			combination = new ArrayList<>();
			N = 0; // 재료의 수
			L = 0; // 제한 칼로리
			
			// 제한 칼로리 이하의 조합중에서 가장 맛에 대한 점수가 높은 햄버거의 점수
			result = 0;
			
			for(int b = 0; st.hasMoreTokens(); b++) {
				N = Integer.parseInt(st.nextToken()); 
				L = Integer.parseInt(st.nextToken()); 
			}
			
			for(int b = 0; b < N; b++) {
				st = new StringTokenizer(br.readLine());
				
				int T = Integer.parseInt(st.nextToken()); // 맛 점수
				int K = Integer.parseInt(st.nextToken()); // 칼로리
				
				Ingredient ingredient = new Ingredient(T, K);
				list.add(ingredient);
			}
			
			for(int r = 1; r <= N; r++) {
				dfs(0,0,r);
			}
			
			System.out.printf("#%d %d\n", t, result);
		}

	}

	private static void dfs(int depth, int start, int r) {
		
		if (depth == r) {
			// 여기서 combination의 맛 점수와 칼로리합 계산
			int sum = 0;
			int kcal = 0;
			
			for(int a = 0; a < combination.size(); a++) {
				sum += combination.get(a).T;
				kcal += combination.get(a).K;
			}
			
			if(kcal <= L) {
				result = Math.max(sum, result);
			}
			
	        return;
	    }

	    for (int i = start; i < list.size(); i++) {
	        combination.add(list.get(i));
	        dfs(depth + 1, i + 1, r);
	        combination.remove(combination.size() - 1);
	    }
		
	}

}

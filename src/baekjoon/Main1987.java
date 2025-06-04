package baekjoon;

import java.util.*;
import java.io.*;

public class Main1987 {
	
	// 상하좌우 4방향 DFS탐색문제 
	// 근데 같은 문자가 아니라 이번에는 한번도 안나온 알파벳을 찾아야한다.
	// 말이 놓여있는 좌측상단칸도 포함이라 result = 1;로 시작
	// 입력으로 주어진 서로다른 알파벳을 모두 저장한다. - 알바벳 등장 저장기록을 위해서
	// 최대한 몇 칸을 지날 수 있는지를 구하는것이기 때문에 DFS를 한번하고 끝내면 안된다.
	// 즉 백트레킹을 이용해서 저장기록을 되돌리고 현재 위치에서 아직 가지못한 루트를 전부 탐색해야한다.
	// DFS를 몇번 돌려야할지 모르겠는데 그건 일단 짜면서 생각해봐야겠다.
	
	static char[][] arr;
	static Map<Character, Boolean> map = new HashMap<>();
	static int C;
	static int R;
	static int result;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new char[C][R];
		result = 1; // 지나간 칸 수
		
		for(int a = 0; a < C; a++) {
			String line = br.readLine();
			for(int b = 0; b < R; b++) {
				arr[a][b] = line.charAt(b);
			}
		}
		
		dfs(0, 0, 1);
		
		System.out.println(result);
	}
	
	static void dfs(int a, int b, int depth) {
		map.put(arr[a][b], true);
		result = Math.max(result, depth);
		
		int[] da = {-1,1,0,0};
		int[] db = {0,0,-1,1};
		
		int na, nb;
		for(int i = 0; i < 4; i++) {
			na = da[i] + a;
			nb = db[i] + b;
			
			if(na >= 0 && na < C && nb >= 0 && nb < R && !map.containsKey(arr[na][nb])) {
				dfs(na, nb, depth+1);
			}
		}
		map.remove(arr[a][b]);
	}
	
}
















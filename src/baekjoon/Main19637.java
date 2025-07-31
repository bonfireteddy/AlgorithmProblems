package baekjoon;

import java.util.*;
import java.io.*;

public class Main19637 {
	
	// 레벨 입력이 오름차순으로 주어졌으니까 기준이 되는 전투력으로
	// 이분탐색해서 구간 별로 나눈다음 그 구간에 맞게 해탕 전투력으로 출력하면 되나?
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> powerLevel = new HashMap<>();
		
		for(int a = 0; a < N; a++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int level = Integer.parseInt(st.nextToken());
			powerLevel.put(name, level);
		}
		
		int[] powerLevels = new int[M];
		
		for(int a = 0; a < N; a++) {
			int level = Integer.parseInt(br.readLine());
			powerLevels[a] = level;
		}
		
		
	}

}

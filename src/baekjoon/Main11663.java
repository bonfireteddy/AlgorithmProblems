package baekjoon;

import java.util.*;
import java.io.*;

public class Main11663 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] vertexs = new int[N];
		List<int[]> edges = new ArrayList();
		
		st = new StringTokenizer(br.readLine());
		for(int a = 0; a < N; a++) {
			vertexs[a] = Integer.parseInt(st.nextToken());
		}
		
		for(int a = 0; a < M; a++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			edges.add(new int[] {start, end});
		}
		
	}

}

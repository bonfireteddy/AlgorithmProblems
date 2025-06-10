package baekjoon;

import java.util.*;
import java.io.*;

public class Main11659 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 누적합 배열: 크기 N+1 (1-based 인덱스 편하게)
		int[] prefixSum = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int a = 1; a <= N; a++){
			int num = Integer.parseInt(st.nextToken());
			prefixSum[a] = prefixSum[a-1] + num;
			// a까지의 누적합 = a직전까지의 누적합 + a번째 숫자
		}
		
		for(int a = 0; a < M; a++){
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			// i부터 j까지의 구간합
			int sum = prefixSum[j] - prefixSum[i-1];
			System.out.println(sum);
		}
	}

}

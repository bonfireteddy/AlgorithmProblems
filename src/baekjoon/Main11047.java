package baekjoon;

import java.util.*;
import java.io.*;

public class Main11047 {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		
		for(int a = 0; a < N; a++) {
			coins[a] = Integer.parseInt(br.readLine());
		}
		
		int min = 0;
		
		for(int a = N-1; a >= 0; a--) {
			if(coins[a] <= K) { // K보다 코인이 작은 경우
				min += K / coins[a]; // 몫
				K -= (K / coins[a]) * coins[a];  
			}
		}
		
		System.out.println(min);
	}
}

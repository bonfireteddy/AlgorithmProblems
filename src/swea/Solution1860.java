package swea;

import java.util.*;
import java.io.*;

public class Solution1860 {
	
	// N의 사람들이 붕어빵을 먹을 수 있음 
	// 0초~M초에 K개의 붕어빵 제조가능
	// 붕어빵을 만들고 다음 붕어빵을 만들기 전 비는 시간은 없음
	// 0초 이후에 손님들이 언제 도착하는지 주어지면, 모든 손님들에게 
	// 기다리는 시간 없이 붕어빵을 제공할 수 있는지 판별.
	// job scheduling 인듯?
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			String result = "";
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int a = 0; a < N; a++) {
				arr[a] = Integer.parseInt(st.nextToken());
			}
			
			
			
			System.out.printf("#%d %d\n", test_case, result);
		}
	}

}

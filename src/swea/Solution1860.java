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
	// 현재 몇초가 지났는지 저장해나가면서 붕어빵의 개수도 늘려간다.
	// arr[] -> 오름차순으로 정렬시켜야함.
	
	public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			String result = "";
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] arrival = new int[N]; // 손님들이 도착하는 시간 배열
			for(int a = 0; a < N; a++) {
				arrival[a] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arrival); // 배열 오름차순 정렬
			result = "Possible";
            
            for (int i = 0; i < N; i++) {
                int t = arrival[i];
                int breadMade = (t / M) * K; // t초까지 만든 붕어빵 수
                int customers = i + 1;       // t초까지 도착한 손님 수
                if (breadMade < customers) {
                    result = "Impossible";
                    break;
                }
            }
            
			System.out.printf("#%d %s\n", test_case, result);
		}
	}

}












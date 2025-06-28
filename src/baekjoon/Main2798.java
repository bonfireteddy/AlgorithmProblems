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
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int a = 0; a < N; a++) {
			arr[a] = Integer.parseInt(st.nextToken());
		}
		
		for(int a = 0; a < N; a++) {
			int current = arr[a];
			for(int b = 0; b < N && b != a; b++) {
				current += arr[b];
				for(int c = 0; c < N && c != b && c != a; c++) {
					current += arr[c];
					if(current <= M) {
						max = Math.max(max, current);
					}
					current -= arr[c];
				}
				current -= arr[b];
			}
			
		}
		
		System.out.println(max);
	}
}

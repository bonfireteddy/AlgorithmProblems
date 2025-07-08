package baekjoon;

import java.util.*;
import java.io.*;

// 두 배열을 합치고 정렬한 결과를 출력하면 된다.
// 시간복잡도를 고려해야하는 문제인 것 같은데, 어떤 방식이 효율적으로 배열을 
// 정렬 시킬 수 있을까?

public class Main11728 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		int[] B = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int a = 0; a < N; a++) {
			A[a] = Integer.parseInt(st.nextToken());	
		}
		st = new StringTokenizer(br.readLine());
		for(int a = 0; a < M; a++) {
			B[a] = Integer.parseInt(st.nextToken());	
		}
		
		StringBuilder sb = new StringBuilder();
		
		int i = 0;
		int j = 0;
		while(i < N && j < M) {
			if(A[i] <= B[j]) {
				sb.append(A[i] + " ");
				i++;
			}else{
				sb.append(B[j] + " ");
				j++;
			}
		}
		
		while(i < N) {
			sb.append(A[i] + " ");
			i++;
		}
		while(j < M) {
			sb.append(B[j] + " ");
			j++;
		}
		
		System.out.println(sb.toString());
	}

}

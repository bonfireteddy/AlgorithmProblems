package baekjoon;

import java.util.*;
import java.io.*;

public class Main11399 {
	
	// 예시에 나온 것 처럼 돈을 인출하는데 걸리는 시간을 오름차순으로 정렬한다음 
	// 합을 구하는게 시간의 합을 최소로 만드는 방법인 듯 하다.
	// 들어온 입력 오름 차순으로 정렬하고 반복문 돌리면서 더할 수가 이전에 수를 더해온 값이 
	// 될 수 있도록 코드를 구성한다.
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		
		for(int a = 0; a < N; a++) {
			arr[a] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		int sum = 0;
		
		Arrays.sort(arr); // 오름차순 정렬
		
		for(int a = 0; a < N; a++) {
			sum += arr[a];
			result += sum;
		}
		
		System.out.println(result);
	}

}

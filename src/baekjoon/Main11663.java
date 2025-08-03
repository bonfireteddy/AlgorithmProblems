package baekjoon;

import java.util.*;
import java.io.*;

public class Main11663 {
	
	// 그냥 범위에 있나 하나하나 확인하면서 하면 시간복잡도가 N^2이 된다. 이러면 100억이라 시간초과
	// 이분탐색으로 풀어서 시간복잡도를 줄여야하는데, 이게 왜 이분탐색으로 풀 수 있는건지 방법이 
	// 떠오르지가 않음. 일단 뭔가 선분의 시작점과 끝점이 주어지면 이걸 start, end로 한다음에 mid를 구하
	// 는건가? 싶긴한데. 아닌가
	
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
		
		Arrays.sort(vertexs); // 배열 오름차순 정렬
		
		for(int i = 0; i < M; i++) {
			int lower = lowerBound(vertexs, edges.get(i)[0]);
			int upper = upperBound(vertexs, edges.get(i)[1]);
			System.out.println(upper - lower);
		}
	}
	
	// 구간 안에 들어오기 시작하는 인덱스
	static int lowerBound(int[] arr, int target) {
	    int left = 0, right = arr.length;
	    while (left < right) {
	        int mid = (left + right) / 2;
	        if (arr[mid] < target) left = mid + 1;
	        else right = mid;
	    }
	    return left;
	}
	
	// 구간에서 벗어나는 인덱스
	static int upperBound(int[] arr, int target) {
	    int left = 0, right = arr.length;
	    while (left < right) {
	        int mid = (left + right) / 2;
	        if (arr[mid] <= target) left = mid + 1;
	        else right = mid;
	    }
	    return left;
	}

}

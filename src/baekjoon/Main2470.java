package baekjoon;

import java.util.*;
import java.io.*;

public class Main2470 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int a = 0; a < N; a++) {
			arr[a] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); // 배열 오름차순 정렬
		int left = 0;
		int right = N-1;
		int min = Integer.MAX_VALUE;
		int minLeft = 0;
		int minRight = 0;
		while(left < right) {
			int sum = arr[left] + arr[right];
			
			// 절대값 기준으로 가장 작은 수로 비교하면 0과 가장 가까운 값을 찾을 수 있음
			if(Math.abs(sum) < min) { // 같을 때 말고 작을 경우에만 최소값 갱신
				min = Math.abs(sum);
				minLeft = arr[left];
				minRight = arr[right];
			}
					
			if(sum == 0) {
				break; // 0이 나온 경우 바로 종료
			}else if(sum > 0) { // 합이 양수인 경우
				right--;
			}else if(sum < 0){ // 합이 음수인 경우
				left++;
			}
		}
		
		System.out.println(minLeft + " " + minRight);
	}

}

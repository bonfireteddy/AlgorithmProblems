package java1208;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] arr = new int[100];
	static int max;
	static int maxIndex;
	static int min;
	static int minIndex;
	static int value;
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			max = Integer.MIN_VALUE;  // 초기화!
		    min = Integer.MAX_VALUE;  // 초기화!
			
			int dumpCount = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int a=0; st.hasMoreTokens(); a++) {
				arr[a] = Integer.parseInt(st.nextToken());
			}
			
			while(dumpCount > 0) {
				max = Integer.MIN_VALUE;  // 초기화!
			    min = Integer.MAX_VALUE;  // 초기화!
				// 최대값 최소값 찾기
				for(int a=0; a<arr.length; a++) {
					max = Math.max(arr[a], max);
					if(arr[a] == max) {
						maxIndex = a;
					}
					min = Math.min(arr[a], min);
					if(arr[a] == min) {
						minIndex = a;
					}
				}
				
				if(max - min > 1) {
					arr[maxIndex] -= 1;
					arr[minIndex] += 1;
					
					dumpCount--;
				}
				
				// 주어진 덤프 횟수 이내에 평탄화가 완료된 경우 평탄화 검사
				// 모든 check가 0일 경우에 dumpCount가 0이 되도록
				boolean clear = true;
				for(int a=1; a<arr.length; a++) {
					int check = arr[0]-arr[a];
					if(check != 0) {
						clear = false;
					}
				}
				if(clear == true) {
					dumpCount = 0;
				}
				
			}
			 // 마지막 max, min 다시 구하기
		    max = Integer.MIN_VALUE;
		    min = Integer.MAX_VALUE;
		    for (int a = 0; a < arr.length; a++) {
		        max = Math.max(max, arr[a]);
		        min = Math.min(min, arr[a]);
		    }
			value = max - min;
			System.out.printf("#%d %d\n", test_case, value);
			
		}

	}
}

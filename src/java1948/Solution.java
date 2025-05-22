package java1948;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	// 뒤에 날짜 순서대로 int배열에 저장
	// 반복문 시작을 첫번재 월로 하고 중간에 나오는 월 일수는 int 배열에 
	// 접근해서 가져오면 될듯
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] arr = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31,  30, 31};
		
		for(int t = 1; t <= T; t++) {
			
			int result = 0;
			
			int startMonth = 0;
			int startDay = 0;
			int endMonth = 0;
			int endDay = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			startMonth = Integer.parseInt(st.nextToken());
			startDay = Integer.parseInt(st.nextToken());
			endMonth = Integer.parseInt(st.nextToken());
			endDay = Integer.parseInt(st.nextToken());
			
			if(endMonth - startMonth == 0) {
				result = endDay - startDay + 1;
			} else {
				result += arr[startMonth] - startDay + 1;
				for(int a = startMonth+1 ; a < endMonth; a++) {
					result += arr[a];
				}
				result += endDay;
			}
			
			System.out.printf("#%d %d\n", t, result);
		}
	}

}

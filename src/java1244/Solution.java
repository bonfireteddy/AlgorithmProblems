package java1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	// 동일한 위치의 교환이 중복되면 안된다.
	// 하지만 94처럼 숫자가 2개일 경우 2회 교환하면 원래의 94로된다. 
	// 숫자가 2개일 경우 교환 중복 허용
	// 주어진 숫자의 자리수 변경을 통해 최대값을 만드는 문제
	// 맨 앞에는 숫자중에서 가장 큰 값이 와야하고 뒤로 보낼 수 있는 숫자중에서도
	// 가장 큰 자리수로 옮기는 것에 유의해야 한다.
	// 교환은 하는데 앞에 더 큰 수가 올 수 있도록 해야함.
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		int maxValue = 0;
		
		for(int a = 1; a <= testCase; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int value = Integer.parseInt(st.nextToken());
			int change = Integer.parseInt(st.nextToken());
			
			// 이쪽 부분에 알고리즘 작성
			
			
			System.out.printf("#%d %d\n", a, maxValue);
		}
		
	}

}

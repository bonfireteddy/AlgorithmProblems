package java1984;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[10];
			
			for(int a = 0; a < 10; a++) {
				arr[a] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr); // 오름차순 정렬
			
			int sum = 0;
			for(int a = 1; a < 9; a++) {
				sum += arr[a];
			}
			result = (int) Math.round(sum / 8.0);
			System.out.printf("#%d %d\n", t, result);
		}

	}

}

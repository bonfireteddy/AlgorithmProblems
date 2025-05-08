package java1208;

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
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			
			int dumpCount = Integer.parseInt(br.readLine());
			
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int a=0; a < 100; a++) {
				arr[a] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < dumpCount; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}
			Arrays.sort(arr);
			int result = arr[99] - arr[0];
			
			System.out.printf("#%d %d\n", test_case, result);
			
		}

	}
}

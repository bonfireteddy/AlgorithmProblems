package java1970;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());	
			String result = "";
			
			int[] arr = {50000,10000,5000,1000,500,100,50,10};
			
			for(int i = 0; i < 8; i++) {
				int a = N/arr[i];
				result += String.valueOf(a)+" ";
				N -= a * arr[i];
			}
			
			System.out.printf("#%d\n%s\n", t, result);
		}
	}
}

package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution1213 {
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 1;
		
		for(int t = 1; t <= 10; t++) {
			int v = Integer.parseInt(br.readLine());
			
			int result = 0;
			
			String str = br.readLine();
			String longStr = br.readLine();
			
			for(int a = 0; a <= longStr.length()-str.length(); a++) {
				String s = longStr.substring(a, a+str.length());
				//System.out.print(s+" \n");
				
				if(str.equals(s)) {
					result++;
				}
			}
			
			System.out.printf("#%d %d\n", t, result);
		}
	}
}

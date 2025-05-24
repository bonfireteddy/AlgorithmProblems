package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1989{
	
	// 회문(palindrome)문제이다. 앞과 뒤에서 왔다갔다하면서 일치하는지 확인하면 될듯?
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int result = 1;
			
			String str = br.readLine(); 
			
			for(int a = 0; a < str.length()/2; a++) {
				char start = str.charAt(a);
				char end = str.charAt(str.length()-1-a);
				
				if(start != end) {
					result = 0;
				}
			}
			
			System.out.printf("#%d %d\n", t, result);
		}
		
	}
}
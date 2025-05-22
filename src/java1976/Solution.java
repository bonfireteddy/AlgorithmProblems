package java1976;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	
	
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int result = 0;
			
			int fh = 0;
			int fm = 0;
			int sh = 0;
			int sm = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			fh = Integer.parseInt(st.nextToken());
			fm = Integer.parseInt(st.nextToken());
			sh = Integer.parseInt(st.nextToken());
			sm = Integer.parseInt(st.nextToken());
			
			int h = fh + sh;
			int m = fm + sm;
			if(m > 59) {
				h++;
				m -= 60;
			}
			
			if(h > 12) {
				h -= 12;
			} 
			System.out.printf("#%d %d %d\n",t, h, m);
		}
	}
}
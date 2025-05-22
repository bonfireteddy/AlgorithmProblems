package java1946;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	// 그냥 싸잡아서 싹 다 붙이고 10개씩 짤라서 출력하는게 나을듯?
	
	public static void main(String[] args) throws IOException{
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int result = 0;
			
			int N = Integer.parseInt(br.readLine());
			
			List<String[]> pairs = new ArrayList<>();
			
			for(int a = 0; a < N; a++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String alp = st.nextToken();
				String num = st.nextToken();
				pairs.add(new String[]{alp,num});
			}
			
			System.out.printf("#%d\n", t);
			
			// 모든 요소 한줄로 붙이기
			String allString = "";
			for (String[] pair : pairs) {
				int count = Integer.parseInt(pair[1]);
				for (int a = 0; a < count; a++) {
					allString += pair[0];
				}
			}
			
			for(int a = 0; a < allString.length(); a++) {
				if(a % 10 == 0 && a != 0) {
					System.out.println();
				}
				System.out.print(allString.charAt(a));
			}
			System.out.println();
		}
	}

}

package swea;

import java.util.*;
import java.io.*;

public class Solution1289 {
	
	// 메모리 bit중 하나를 골라 0인지 1인지 결정하면 해당 값이 메모리의 끝까지 덮어씌우는 방식으로
	// 모든 비트가 0인 상태에서 원래 상태로 돌아가는데 걸리는 최소 횟수
	// 0011이면 3번째 자리를 1로 설정하면 1번만에 가능하다.
	// 100이면 1번째 자리를 1로 설정하고 두번째 자리를 0으로 해야하기 때문에 2번만에 가능하다.
	// 최소 횟수를 구하려면 가장 첫번째 1부터 찾아야한다. 바로 원래 비트랑 현재 비트랑 자리 수 비교하면서
	// 맞지 않으면 뒤에꺼 다 바꾸고 반복하면서 하면 될듯.
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= 10; test_case++){
			
			int result = 0;
			
			String str = br.readLine();
			String currentStr = "";
			
			for(int a = 0; a < str.length(); a++) {
				currentStr += "0";
			}
			
			for(int a = 0; a < str.length(); a++) {
				if(str.equals(currentStr)) {
					break;
				}
				
				char sc = str.charAt(a);
				char cc = currentStr.charAt(a);
				
				if(sc != cc) {
					String replaced = currentStr.substring(0, a);
					String onezeros = "";
					for(int z = a; z < str.length(); z++) {
						if(sc == '0') {
							onezeros += "0";
						}else {
							onezeros += "1";
						}
					}
					currentStr = replaced + onezeros;
					result++;
				}
				
			}
			
			System.out.printf("#%d %d\n", test_case, result);
		}
	}

}

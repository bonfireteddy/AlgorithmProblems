package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2007 {
	
	// 중복된 부분을 체크해야하는데 어떻게 할 수 있을까?
	// 1개 기준으로 다음것이 1개랑 같은지 확인 
	// 다음 2개기준 2개 3개기준 2개 이렇게 찍어보다가
	// 그 2개가 딱 맞아 떨어지면 그 테스트케이스의 중복문자열이 그거임
	// 그 중복문자열을 기준으로 그 문자열이 몇개가 나오는지 체크하면 완료
	// 
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int result = 0;
			
			char[] arr = new char[30];
			String line = br.readLine();
			for(int a= 0; a < 30; a++) {
				arr[a] = line.charAt(a);
			}
			
			String str = "";
			
			// 똑같은 단어 찾기

			for (int len = 1; len <= 15; len++) { // 반복 길이: 1부터 15까지 시도
			    String str1 = "";
			    String str2 = "";
			
			    // 문자열이 범위 초과하지 않게 확인
			    if (2 * len > arr.length) break;
			
			    for (int i = 0; i < len; i++) {
			        str1 += arr[i];
			        str2 += arr[i + len];
			    }
			
			    if (str1.equals(str2)) {
			    	str = str1;
			        //System.out.println(str1);
			        break;
			    }
			}
			
			result = str.length();
			
			System.out.printf("#%d %d\n", t, result);
		}
		
	}

}

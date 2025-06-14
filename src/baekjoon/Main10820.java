package baekjoon;

import java.util.*;
import java.io.*;

public class Main10820 {
	
	// 어떤 문장이 주어졌을때 그 문장에서 
	// 소문자, 대문자, 숫자, 공백의 개수를 뽑을 수 있는 지 묻는 문제
	// 와... 나 이거 할 줄 모른다..
	// 저거 중에서 공백정도? 만 가능할지도
	// 그리고 문자열이 N개가 주어진다고 했는데, N을 입력으로 받는게 없다...
	// 어떻게 처리해야되는거지?
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line = br.readLine()) != null) {
			int lower = 0; // 소문자
			int upper = 0; // 대문자
			int digit = 0; // 숫자 - digit 뜻이 숫자를 의미한다.
			int space = 0; // 공백
			
			for(char c : line.toCharArray()) {
				if(Character.isLowerCase(c)) lower++;
				else if(Character.isUpperCase(c)) upper++;
				else if(Character.isDigit(c)) digit++;
				else if(c == ' ') space++;
			}
			
			System.out.printf("%d %d %d %d\n", lower, upper, digit, space);
		}
		
		
	}

}

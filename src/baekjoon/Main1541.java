package baekjoon;

import java.util.*;
import java.io.*;

public class Main1541 {
	
	// 이번 문제는 그거다 -가 나온 시점에바로 괄호 꺼내고 
	// 또 -가 나올때까지 계속가다가 끝에 오거나 또 -가 나온 경우 괄호를 닫는다.
	// 굳이 괄호를 넣을 필요까지는 없을 것 같고 그냥 따로 모아가지고 더해주면 될듯?
	
	// 그러고 보니까 어떻게 숫자랑 문자를 구분해서 어떻게 저장하지?
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		List<String> list = new ArrayList<>();
		
		for(int a = 0; a < line.length(); a++) {
			char c = line.charAt(a);
			
			if(c == '+' || c== '-') {
				list.add(sb.toString()); // 쌓아뒀던 char전부 list에 추가
				
				sb.setLength(0); //  초기화
				
				list.add(String.valueOf(c)); // 부호 list에 추가
			}else {
				sb.append(c);
			}
		}
		
		// 마지막 숫자 추가
		if(sb.length() > 0) {
			list.add(sb.toString());
		}
		
		int sum = 0;
		int minusSum = 0;
		boolean minus = false;
		
		for(int a = 0; a < list.size(); a++) {
			String value = list.get(a);
			
			if(value.equals("-")) {
				minus = true;
			} else if(value.equals("+")) {
				continue;
			} else if(minus) {
				minusSum += Integer.parseInt(value);
			} else {
				sum += Integer.parseInt(value);
			}
		}
		
		System.out.println(sum - minusSum);
	}
}

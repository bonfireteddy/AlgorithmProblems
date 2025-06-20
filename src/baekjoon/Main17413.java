package baekjoon;

import java.util.*;
import java.io.*;

public class Main17413 {
	
	// 단어만 쏙쏙 골라서 거꾸로 뒤집으려고 하는건데, FILO인 Stack자료구조 이용하면
	// 쉽게 풀 수 있을듯? 태그가  <로 시작해서>로 끝나는 부분만 그대로 두고 나머지는 전부 
	// Stack에 넣고 뒤집에서 출력하자
	// 그때그때 Stack에 넣고 바로 출력할지, 아니면 입력받을때부터 전부 Stack에 넣고 몇개인지
	// 계산해뒀다가 개수 맞춰서 출력할지... 어떻게 할까.
	// 근데 이거 deque을 이용하면 진짜 쉽게 풀 수 있을 것 같긴한데...
	// 입력 받은 거 전부다 deque에 넣고 괄호 > 닫힌 부분부터만 ㄷ
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		Deque<Character> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		boolean isTag = false; // Deque에 넣을지 말지 상태 지정
		
		for(char ch : input.toCharArray()) {
			
			if(ch == ' ' && !isTag) {
				while(!dq.isEmpty()) {
					sb.append(dq.pollLast());
				}
				sb.append(' ');
			}else if(ch == '<') {
				isTag = true;
				while(!dq.isEmpty()) {
					sb.append(dq.pollLast());
				}
				sb.append(ch);
			}else if(ch == '>') {
				isTag = false;
				while(!dq.isEmpty()) {
					sb.append(dq.pollFirst());
				}
				sb.append(ch);
			}else {
				dq.addLast(ch);
			}
			
		}
		// 마지막 단어 처리
		while(!dq.isEmpty()) {
			sb.append(dq.pollLast());
		}
		System.out.println(sb.toString());
	}

}

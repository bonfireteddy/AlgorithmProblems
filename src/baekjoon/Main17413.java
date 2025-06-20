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
		String str = br.readLine();
		
		char[] arr = new char[str.length()];
		Stack<Character> st = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		boolean open = true; // stack에 넣을지 말지 상태 지정
		for(int a = 0; a < str.length(); a++) {
			
			char c = str.charAt(a);
			if(c == '<') {
				open = false;
				while(!st.isEmpty()) {
					sb.append(st.pop());
				}
			}
			if(c == '>') {
				open = true;
				sb.append(str.charAt(a));
			}
			if(!open){
				sb.append(str.charAt(a));
			}else if(open && c == ' ') { // 공백을 만나면 그때 stack 전부 pop
				while(!st.isEmpty()) {
					sb.append(st.pop());
				}
				sb.append(' ');
			}else if(open && c != '<' && c != '>'){
				st.add(c);
			}
			
		}
		
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		
		System.out.println(sb);
	}

}

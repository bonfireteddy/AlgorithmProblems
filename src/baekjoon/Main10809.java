package baekjoon;

import java.util.*;
import java.io.*;

public class Main10809 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int[] alphabet = new int[26];  // 'a' ~ 'z'
		for (int i = 0; i < 26; i++) {
			alphabet[i] = -1;  // 초기화: 모두 -1
		}
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int idx = c - 'a'; // 알바벳 a기준 몇번째 숫자인지 설정
			if (alphabet[idx] == -1) {  // 처음 나오는 경우에만 저장
				alphabet[idx] = i;
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			sb.append(alphabet[i]).append(" ");
		}
		System.out.println(sb);
		
	}
	     
}

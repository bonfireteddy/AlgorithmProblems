package baekjoon;

import java.util.*;
import java.io.*;

public class Main11656{
	
	// 전제문자열부터 앞에서부터 하나씩 뺀 문자열들을 String배열이든 리스트든 저장하고
	// 이 배열이나 리스트 기준으로 사전순 정렬을 적용시키면 되는데...
	// 이게 오름차순 정렬이랑 똑같은 건가?
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		List<String> strList = new ArrayList<>();
		String[] strArr = new String[line.length()];
		
		char[] charArr = line.toCharArray();
		for(int a = 0; a < line.length(); a++) {
			String str = "";
			for(int b = a; b < line.length(); b++) {
				str += charArr[b];
			}
			strArr[a] = str;
		}
		
		Arrays.sort(strArr);
		Collections.sort(strList);
		
		for(int a = 0; a < line.length(); a++) {
			System.out.println(strArr[a]);
		}
	}
}

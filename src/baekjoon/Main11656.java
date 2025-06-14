package baekjoon;

import java.util.*;
import java.io.*;

public class Main11656{
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		int len = line.length();
		String[] suffixes = new String[len];

		// 접미사 만들기
		for (int i = 0; i < len; i++) {
		    suffixes[i] = line.substring(i);
		}

		// 사전순 정렬
		Arrays.sort(suffixes);

		// 출력
		for (String suffix : suffixes) {
		    System.out.println(suffix);
		}
	}
}

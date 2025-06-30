package baekjoon;

import java.util.*;
import java.io.*;

public class Main15721 {
	
	// T는 뻔이나 데기가 나오는 번째이고
	// 뻔에관한 T인지 데기에 관한 T인지는 N입력을 보고 정한다.
	// 일정한 규칙을 가진 전체 A에서 뻔 또는 데기가 몇번째로 나왔는지 확인하고 
	// 그때 순서가 전체 A에서 몇번째인지 구하는 문제.
	// n-1회차 문장일 때는 ‘뻔 – 데기 – 뻔 – 데기 – 뻔(x n번) – 데기(x n번)’
	// 뻔은 0, 데기는 1로 주어진다.
	// 저 위에 규칙대로 배열에 집어넣는게 일단 관건인데 이걸 어떻게 하지?
	// 어떻게 규칙대로 배열에 집어넣을 수 있지?
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new LinkedList<Integer>();
		
		int countDq = 2; // dq초기화 회차
		int countN = 0; // 0 또는 1이 나오는 회차
		int countA = 0; // 현재 사람 번호
		
		while(true) {
			if(dq.isEmpty()) {
				// 1회차 dq초기화 - 초기 4개부분
				dq.add(0);dq.add(1);dq.add(0);dq.add(1);
				// 1회차 dq초기화 - 뒤에 n번 반복 뻔 부분
				for(int a = 0; a < countDq; a++) {
					dq.add(0);
				}
				// 1회차 dq초기화 - 뒤에 n번 반복 데기 부분
				for(int a = 0; a < countDq; a++) {
					dq.add(1);
				}
				countDq++; // 회차 추가
			}
			
			int current = dq.pollFirst();
			
			if(current == N) countN++;
			if(countN == T) break;
			countA = (countA + 1) % A;
		}
		
		System.out.println(countA);
	}
	
}

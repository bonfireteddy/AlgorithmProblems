package swea;

import java.util.*;
import java.io.*;

public class Solution1225 {
	
	// 첫번째 숫자 1감소 ~ 5감소까지가 1사이클
	// 다음 사이클 부터 다시 1~5감소까지 하고 뒤로 보내기
	// 구조가 딱 Queue사용하라고 대놓고 얘기함
	// Integer범위 제한 있어서 다른 타입 생각안해도 됨
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			
			int T = Integer.parseInt(br.readLine());
			int result = 0;
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int a = 0; a < 8; a++) {
				int v = Integer.parseInt(st.nextToken());
				q.offer(v);
			}
			
			int count = 0;
			while(true) {
				count += 1;
				int b = q.poll();
				
				int v = b - count;
				if(v <= 0) {
					v = 0;
					q.offer(v);
					break;
				}
				
				q.offer(v);
				
				if(count == 5) { // 사이클 한바퀴
					count = 0;
				}
			}
			
			System.out.printf("#%d ", t);
			for(int a = 0; a < 8; a++) {
				int v = q.poll();
				System.out.printf("%d ",v);
			}
			System.out.println();
		}
		
	}

}

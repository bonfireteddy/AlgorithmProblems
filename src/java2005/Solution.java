package java2005;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	// 파스칼의 삼각형 규칙
	// 첫번째요소와 마지막요소가 항상 1이다
	// 첫번째 요소와 마지막 요소가 아닌 것들은 
	// 이전 a줄에서 b-1요소와 b요소의 합으로 결정된다. 
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			//파스칼의 삼각형 만들기
			int[][] arr = new int[N][N];
			
			for(int a = 0; a < N; a++) {
				for(int b = 0; b <= a; b++) {
					if(a == 1 || b == 0 || b == a) { // 1이 나오는 경우
						arr[a][b] = 1;
					}else {
						arr[a][b] = arr[a-1][b-1] + arr[a-1][b]; 
					}
				}
			}
			
			System.out.printf("#%d\n", t);
			for(int a = 0; a < N; a++) {
				for(int b = 0; b < N; b++) {
					if(arr[a][b] == 0) {
						System.out.print(" ");
					}else {
						System.out.print(arr[a][b]+" ");
					}
				}
				System.out.println();
			}
		}

	}

}

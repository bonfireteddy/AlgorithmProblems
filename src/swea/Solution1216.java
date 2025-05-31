package swea;

import java.util.*;
import java.io.*;

public class Solution1216 {
	
	// 100x100 이차원 배열에서 가장 긴 회문의 길이를 구하는 문제 
	// 슬라이딩 윈도우로 해결!
	// 3중 for문으로 해결 가능하다고 생각한다.
	// 이중 for문안에 가로열 회문탐색 for문, 세로열 회문탐색 for문 각각 하나씩
	// a열 한번, b열한번, 슬라이딩 윈도우 a,b각각 한번씩
	
	// 중심확장법 사용 => 하나 선택해서 양쪽으로 확장하는 식으로
	// 근데 홀수일때랑 짝수일때랑 구분해서 해야함 홀수일때는 left right가 같다고 두고 
	// 짝수일때는 right가 left+1로 두고 양쪽으로 1식 더해가면서 양쪽에서 0이나 N-1을 만날때까지
	// 뻗으면서 같은지 다른지 검증하면 완성 
	// 그리고 이걸 100x100평편에서 하는거니까 이중 for문 안에다가 가로 방식 세로방식해서 2개 넣으면 될듯?
	
	static int result = 0;
	static char[][] arr;
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			result = 0;
			int tc = Integer.parseInt(br.readLine());
			arr = new char[100][100];
			
			// 2차원 배열 초기화
			for(int a = 0; a < 100; a++) {
				String str = br.readLine();
				for(int b = 0; b < 100; b++) {
					char ch = str.charAt(b); 
					arr[a][b] = ch;
				}
			}
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					// 홀수 길이 (1, 3, 5...)
					expandHorizontal(i, j, j);       // 행 i, 열 j를 중심
					expandHorizontal(i, j, j + 1);
					
					// 짝수 길이 (2, 4, 6...)
					expandVertical(j, i, i);         // 열 i, 행 j를 중심
					expandVertical(j, i, i + 1);
					
				}
			}
			
			System.out.printf("#%d %d\n", tc, result);
		}
		
	}
	
	// 점하나에 대한 중심확장법 함수
	// 가로 방향 확장
	static void expandHorizontal(int row, int left, int right) {
		while (left >= 0 && right < 100 && arr[row][left] == arr[row][right]) {
			int len = right - left + 1;
			result = Math.max(result, len);
			left--;
			right++;
		}
	}
	
	// 세로 방향 확장
	static void expandVertical(int col, int top, int bottom) {
		while (top >= 0 && bottom < 100 && arr[top][col] == arr[bottom][col]) {
			int len = bottom - top + 1;
			result = Math.max(result, len);
			top--;
			bottom++;
		}
	}
	
}

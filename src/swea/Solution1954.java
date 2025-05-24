package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1954 {
	
	// 달팽이 순서로 보이게 숫자를 정렬해야하는데
	// 일반적인 출력순서로 앞에서부터 하는건... 공식이 있나? 모르겠다.
	// 2차원 배열을 만들고 1씩 더하는 와중에 상하좌우로 지나는 인덱스의 
	// 규칙을 파악해서 숫자를 집어 넣고 2차원배열을 순서대로 출력한다 
	// 단, N개씩 출력하고 \n 줄바꿈을 해줘야 재대로 달팽이 모양이 나온다.
	
	// 현재 달팽이 크기 -> 홀수일 때랑 짝수일때랑 
	// 인덱스 계산 공식이 달라지는 듯?
	// 아니다. 홀수든 짝수든 달팽이 크기가 2씩 줄어드는 건 동일
	// 그냥 이렇게 2씩 줄어들게 하고 계산해서 크기 다 채우면
	// 끝내면 될듯?
	// 안쪽 부분 달팽이 크기 snailSize - 2; 
	// 현재 달팽이 크기 snailSize*snailSize
	// value가 현재 달팽이 크기가 되면
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader ar = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(ar.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int snailSize = Integer.parseInt(ar.readLine());
			
			int[][] arr = new int[snailSize][snailSize];
			
			int value = 1;
	        int start = 0;
	        int end = snailSize - 1;
	        
	        while (start <= end) {
	            // → 오른쪽
	            for (int i = start; i <= end; i++) {
	                arr[start][i] = value++;
	            }
	            // ↓ 아래
	            for (int i = start + 1; i <= end; i++) {
	                arr[i][end] = value++;
	            }
	            // ← 왼쪽
	            for (int i = end - 1; i >= start; i--) {
	                arr[end][i] = value++;
	            }
	            // ↑ 위
	            for (int i = end - 1; i > start; i--) {
	                arr[i][start] = value++;
	            }
	            
	            start++;
	            end--;
	            
	        }
			
			System.out.printf("#%d\n", test_case);
			
			for(int a = 0; a < snailSize; a++) {
				for(int b = 0; b < snailSize; b++) {
					System.out.printf("%d ", arr[a][b]);
				}
				System.out.println();
			}
		}
		
	}

}

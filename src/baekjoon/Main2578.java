package baekjoon;

import java.util.*;
import java.io.*;

public class Main2578 {
	
	// 선이 3개 이상 그어지는 순간 빙고
	// 이게 칸마다 8방향 탐색이 아니라 한칸씩 채워나가면서 전체 가로줄, 세로줄, 대각선 2개
	// 중에서 빙고가 3개 나왔을때 멈추면 될듯?
	// 첫째 줄에 사회자가 몇 번째 수를 부른 후 철수가 "빙고"를 외치게 되는지 출력한다.
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[5][5];
		boolean[][] visited = new boolean[5][5];
		int[][] check = new int[5][5];
		
		for(int a = 0; a < 5; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int b = 0; b < 5; b++) {
				int value = Integer.parseInt(st.nextToken());
				arr[a][b] = value;
				visited[a][b] = false;
			}
		}
		
		// 빙고 채우는 순서 기록용 배열
		for(int a = 0; a < 5; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int b = 0; b < 5; b++) {
				check[a][b] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int a = 0; a < 5; a++) {
			for(int b = 0; b < 5; b++) {
				
				int current = check[a][b]; // 빙고체크할 숫자
				
				// 현재 숫자를 방문 처리
				for(int i = 0; i < 5; i++) {
					for(int j = 0; j < 5; j++) {
						if(current == arr[i][j]) {
							visited[i][j] = true;
						}
					}
				}
				
				int bingo = 0;
				// 여기서 현재 visited의 상태가 빙고 3개를 만들경우 멈추고 current출력
				// 가로 세로 빙고 구하기
				for(int i = 0; i < 5; i++) {
					boolean horizonBingoCheck = true,verticalBingoCheck = true;
					for(int j = 0; j < 5; j++) {
						if(!visited[i][j]) horizonBingoCheck = false;
						if(!visited[j][i]) verticalBingoCheck = false;
					}
					if(horizonBingoCheck) bingo++;
					if(verticalBingoCheck) bingo++;
				}
				
				// 대각선 빙고 구하기
				boolean LbingoCheck = true, RbingoCheck = true;
				for(int j = 0; j < 5; j++) {
					if(!visited[j][j]) LbingoCheck = false;
					if(!visited[j][4-j]) RbingoCheck = false;
				}
				if(LbingoCheck) bingo++;
				if(RbingoCheck) bingo++;
				
				if(bingo >= 3) {
					System.out.println(a * 5 + b + 1); // 몇번째 숫자인지 출력
					return;
				}
			}
		}
		
	}

}

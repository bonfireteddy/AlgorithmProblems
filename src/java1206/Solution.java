package java1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	// 조망권이 확보되기 위한 조건
	// 왼쪽과 오른쪽 칸이 2칸이상 확보돼야한다.
	// 각 빌딩의 가장 높은 층부터 양쪽2칸이 비어있는지 확인하고 비어있으면 바로 아래층 검증 
	// 그러다가 2칸이 비어있지 않은 칸이 나오면 다음 빌딩으로 넘어가기
	// 현재 빌딩 높이 - 양 옆 빌딩중 큰 빌딩 높이 => 0이나 음수가 나오면 x
	// 양수가 나올경우 확보 가능 -> 이 양수들을 총합한게 해당 테스트케이스의 출력값
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 10개의 테스트 케이스
		for(int testCase  = 0; testCase < 10; testCase++) {
			
			int N = Integer.parseInt(br.readLine()); // 건물의 개수 - 부지 너비
			StringTokenizer st = new StringTokenizer(br.readLine()); // 건물의 높이
			
			int[] buildings = new int[N];
			
			for(int a  = 0; st.hasMoreTokens(); a++) {
				buildings[a] = Integer.parseInt(st.nextToken());
			}
			
			// 2번건물부터 N-2까지
			int nowBuilding = 2;
			int value = 0; // 확보된 세대의 수
			
			while(nowBuilding < N-2) {
				
				// 현재 건물
				int window = buildings[nowBuilding];
				
				// 현재 건물 높이가 0인경우 다음 건물로 이동
				if(window == 0) {
					window = buildings[nowBuilding+1];
				}
				
				// 현재 건물의 왼쪽 건물에서 더 큰 건물 찾기
				int leftWindow = 0;
				if(buildings[nowBuilding-1] < buildings[nowBuilding-2]) {
					leftWindow = buildings[nowBuilding-2];
				}else {
					leftWindow = buildings[nowBuilding-1];
				}
				
				// 현재 건물의 오른쪽 건물에서 더 큰 건물 찾기
				int rightWindow = 0;
				if(buildings[nowBuilding+1] < buildings[nowBuilding+2]) {
					rightWindow = buildings[nowBuilding+2];
				}else {
					rightWindow = buildings[nowBuilding+1];
				}
				
				// 왼쪽에서 더 큰 건물 오른쪽에서 더 큰 건물 비교
				if(rightWindow > leftWindow) {
					if(window - rightWindow > 0) {
						value += window - rightWindow;
					} 
					
				} else if(rightWindow < leftWindow) {
					if(window - leftWindow > 0) {
						value += window - leftWindow;
					}
				}
				nowBuilding++;
			}
			
			System.out.printf("#%d %d\n", testCase+1, value);
		}
		
	}

}

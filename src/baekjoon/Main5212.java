package baekjoon;

import java.util.*;
import java.io.*;

public class Main5212 {
	
	// X표시의 상하좌우에서 3개이상이 .인 경우 삭제한다.
	// 그렇게 해서 출력된 결과는 모든 X를 포함하는 가장 작은 직사각형으로 한다.
	// 상하좌우 탐색하는 건 dx,dy로 하면 되고 근데 삭제한 결과를 어떻게 하지?
	// 일단 삭제할 X좌표를 저장만 해놓고 한번에 지워야하나? 그게 맞는 것 같다.
	// 그리고 직사각형으로 만드는 건 전부 지워버린 새로운 배열에서 가장 왼쪽에서 발견된
	// X와 가장 오른쪽에서 발견된 X의 좌표에서 x,y의 최대값을 기준으로 하면 될것같다.
	// 그 이상 넘어가면 지워버리기
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[R][C];
		List<int[]> points = new ArrayList<>();
		
		for(int a = 0; a < R; a++) {
			String line = br.readLine();
			for(int b = 0; b < C; b++) {
				arr[a][b] = line.charAt(b);
			}
		}
			
		int[] dr = {0,0,-1,1};
		int[] dc = {-1,1,0,0};
		
		for(int a = 0; a < R; a++) {
			for(int b = 0; b < C; b++) {
				int count = 0;
				if(arr[a][b] == 'X') { // 좌표값이 X인 경우에 4방향 탐색
					for(int i = 0; i < 4; i++) {
						int nr = dr[i] + a;
						int nc = dc[i] + b;
						
						 // 맵을 벗어났으면 → 바다로 간주 (count++)
					    if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
					        count++;
					    }
					    // 맵 안인데 바다(.)라면 → 역시 count++
					    else if (arr[nr][nc] == '.') {
					        count++;
					    }
					}
					if(count >= 3) {
						// 3이상인 경우 좌표 저장
						points.add(new int[]{a, b});
					}
				}
			}
		}
		
		// 저장한 좌표값을 토대로 원래 지도에서 그 부분의 X를 .으로 변환한다.
		// 그 다음 가장 왼쪽과 오른쪽의 X의 가로 세로 값의 최대 부분까지만 남긴 후 출력한다.
		// 좌표 순회
		for (int[] point : points) {
		    int x = point[0];
		    int y = point[1];
		    arr[x][y] = '.';
		}
		
		int maxR = 0;
		int maxC = 0;
		int minR = Integer.MAX_VALUE;
		int minC = Integer.MAX_VALUE;
		
		for(int a = 0; a < R; a++) {
			for(int b = 0; b < C; b++) {
				if(arr[a][b] == 'X') {
					maxR = Math.max(a, maxR);
					maxC = Math.max(b, maxC);
					minR = Math.min(a, minR);
					minC = Math.min(b, minC);
				}
			}
		}
		
		for(int a = minR; a <= maxR; a++) {
			for(int b = minC; b <= maxC; b++) {
				System.out.print(arr[a][b]);
			}
			System.out.println();
		}
	}

}

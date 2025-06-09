package swea;

import java.util.*;
import java.io.*;

public class Solution4615 {
	
	// 크기가 4,6,8 로 정해진 2차원 배열에서 가운데 4칸은 백흑백흑으로 채우고 시작
	// 그니까 내가 이해한대로면 돌을 놓을 수 있는 곳은 상대편 돌의 상하좌우에만 놓을 수 있지만
	// 그때 상대편의 돌을 자신의 돌로 만들 수 있는 자리는 가로/세로/대각선이다.
	// 일단 이 룰 대로 계속 두다가 보드에 빈 곳이 없거나 둘다 돌을 놓을 곳이 없으면 게임이 끝나고
	// 이때 보드에 있는 흑돌과 백돌의 개수를 출력한다. 예제의 경우 흑돌 0개 백돌 16개
	// 일단 풀이 생각해보면 흑돌먼저 시작하기때문에 백돌 4방향 탐색해서 0인자리에 흑돌 놓고 
	// 이때 가로/세로/대각선 현재 차례인 돌이 나올 때까지 탐색해서 내가 놓은 돌과 놓여져있는 사이에 있는 
	// 백돌=2 들을 전부 흑돌로 변환시킨다. 내 돌이 나올 때까지 연속된 상대 돌 전부를 뒤집을 수 있음
	// 근데 내 돌이 없으면 아무일도 안일어남.
	// 따라서 입력으로 주어진 위치에 돌 놓고 8방향 탐색해서 상대돌 연속 체크하다가 내돌만나면 그 중간 전부
	// 뒤집기하고 내 돌안나오면 그냥 두고 반복하면된다.
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			
			int black = 0;
			int white = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			//들어오는 입력이 0라인은 제외하고 들어옴 (1,1)부터 시작
			int[][] arr = new int[N+1][N+1];
			for(int a = 1; a <= N; a++) {
				for(int b = 1; b <= N; b++) {
					arr[a][b] = 0; // 배열 초기화
					// 정가운데 4칸은 먼저 배치하고 시작한다.
					if(a == N/2 && b == N/2){ 
						arr[a][b] = 2;
					}else if(a == (N/2)+1 && b == N/2) {
						arr[a][b] = 1;
					}else if(a == N/2 && b == (N/2)+1) {
						arr[a][b] = 1;
					}else if(a == (N/2)+1 && b == (N/2)+1) {
						arr[a][b] = 2;
					}
				}
			}
			
			int[] da = {-1,1,0,0,-1,1,-1,1};
			int[] db = {0,0,-1,1,-1,1,1,-1};
			
			for(int a = 0; a < M; a++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				arr[x][y] = v;
				
				// 8방향 탐색
				for (int i = 0; i < 8; i++) {
                    int na = x + da[i];
                    int nb = y + db[i];

                    List<int[]> toFlip = new ArrayList<>();

                    while (na >= 1 && na <= N && nb >= 1 && nb <= N) {
                        if (arr[na][nb] == 0) break; // 빈 칸이면 뒤집기 불가
                        if (arr[na][nb] == v) { // 내 돌을 만나면 리스트에 있는 것들 뒤집기
                            for (int[] p : toFlip) {
                                arr[p[0]][p[1]] = v;
                            }
                            break;
                        } else {
                            toFlip.add(new int[]{na, nb}); // 상대 돌이면 리스트에 추가
                        }

                        na += da[i];
                        nb += db[i];
                    }
                }
				
			}
			
			for(int a = 1; a < N+1; a++) {
				for(int b = 1; b < N+1; b++) {
					if(arr[a][b] == 1) {
						black++;
					}else if(arr[a][b] == 2) {
						white++;
					}
				}
			}
			
			System.out.printf("#%d %d %d\n", t, black, white);
		}
		
	}

}

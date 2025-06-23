package baekjoon;

import java.util.*;
import java.io.*;

public class Main1913 {
	
	// dx, dy를 활용하는 방식으로 기존에 생각했던 1부터 안에서 부터 바깥으로 나가는
	// 방식이 아니라 좌표 0,0부터 시작해서 아래, 오른쪽, 위, 왼쪽 순서대로 진행해서
	// 채워나가면 이해하기 훨씬 편하다.
	
	public static void main(String[] args) throws Exception {
		
		// 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N: 달팽이 배열의 크기 (N x N)
        int N = Integer.parseInt(br.readLine());
        // target: 좌표를 찾고자 하는 숫자
        int target = Integer.parseInt(br.readLine());

        // 결과 배열 생성
        int[][] map = new int[N][N];

        // 방향 배열: 아래 → 오른쪽 → 위 → 왼쪽 순서
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // 초기 위치와 방향 설정
        int x = 0, y = 0, dir = 0;
        // 숫자는 N*N부터 1까지 채움
        int num = N * N;

        // target 숫자의 좌표를 저장할 변수
        int targetRow = 0;
        int targetCol = 0;

        // 달팽이 채우기 시작
        while (num > 0) {
            map[x][y] = num;

            // 현재 숫자가 찾고자 하는 숫자일 경우 좌표 저장
            if (num == target) {
                targetRow = x + 1; // 1-based
                targetCol = y + 1;
            }

            // 다음 좌표 계산
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위를 벗어나거나 이미 숫자가 채워져 있다면 방향 전환
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] != 0) {
                dir = (dir + 1) % 4; // 4로 나눠서 방향 조정
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            // 위치 갱신
            x = nx;
            y = ny;
            num--;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        // target 숫자의 위치 출력
        sb.append(targetRow).append(" ").append(targetCol);

        System.out.println(sb);
	}

}

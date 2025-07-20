package baekjoon;

import java.util.*;
import java.io.*;

public class Main21922 {

    public static void main(String[] args) throws Exception {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열

        int[][] arr = new int[N][M]; // 연구실 구조
        boolean[][] visited = new boolean[N][M]; // 최종적으로 바람이 한 번이라도 지나간 칸
        boolean[][][] windVisited = new boolean[N][M][4]; // 방향별로 바람이 이미 지나간 칸인지 확인

        // 연구실 정보 입력
        for (int a = 0; a < N; a++) {
            st = new StringTokenizer(br.readLine());
            for (int b = 0; b < M; b++) {
                arr[a][b] = Integer.parseInt(st.nextToken());
            }
        }

        // 방향: 상(0), 하(1), 좌(2), 우(3)
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        // 모든 에어컨(9번) 위치에서 4방향으로 바람 쏘기
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {

                if (arr[a][b] == 9) {
                    for (int dir = 0; dir < 4; dir++) {
                        int y = a;
                        int x = b;
                        int d = dir;

                        // 바람이 경계 안에서 계속 이동
                        while (y >= 0 && x >= 0 && y < N && x < M) {

                            // 같은 방향으로 이미 지나갔다면 중단
                            if (windVisited[y][x][d]) break;
                            windVisited[y][x][d] = true;

                            // 처음 방문한 칸이라면 카운트용 visited 처리
                            if (!visited[y][x]) {
                                visited[y][x] = true;
                            }

                            int cell = arr[y][x];

                            // 벽에 부딪히면 멈춤
                            if (cell == 1) {
                                // 좌우 방향일 때 막힘
                                if (d == 2 || d == 3) break;
                            } else if (cell == 2) {
                                // 상하 방향일 때 막힘
                                if (d == 0 || d == 1) break;
                            } 
                            // 거울 '/' → 3번
                            else if (cell == 3) {
                                if (d == 0) d = 3;     // 상 → 우
                                else if (d == 1) d = 2; // 하 → 좌
                                else if (d == 2) d = 1; // 좌 → 하
                                else if (d == 3) d = 0; // 우 → 상
                            } 
                            // 거울 '\' → 4번
                            else if (cell == 4) {
                                if (d == 0) d = 2;     // 상 → 좌
                                else if (d == 1) d = 3; // 하 → 우
                                else if (d == 2) d = 0; // 좌 → 상
                                else if (d == 3) d = 1; // 우 → 하
                            }

                            // 다음 칸 이동
                            y += dy[d];
                            x += dx[d];
                        }
                    }
                }
            }
        }

        // 바람이 한 번이라도 지나간 칸 수 세기
        int result = 0;
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                if (visited[a][b]) result++;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}

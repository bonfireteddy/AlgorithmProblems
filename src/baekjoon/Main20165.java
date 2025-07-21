package baekjoon;

import java.util.*;
import java.io.*;

public class Main20165 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열
        int R = Integer.parseInt(st.nextToken()); // 라운드 수

        int[][] arr = new int[N + 1][M + 1];       // 도미노 높이
        boolean[][] visited = new boolean[N + 1][M + 1]; // 넘어진 여부

        for (int a = 1; a <= N; a++) {
            st = new StringTokenizer(br.readLine());
            for (int b = 1; b <= M; b++) {
                arr[a][b] = Integer.parseInt(st.nextToken());
            }
        }

        // 동서남북: E, W, S, N
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int score = 0; // 넘어진 도미노 개수

        for (int r = 0; r < R; r++) {
            // 공격
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            int dir = 0;
            if (d == 'E') dir = 0;
            else if (d == 'W') dir = 1;
            else if (d == 'S') dir = 2;
            else if (d == 'N') dir = 3;

            // 도미노 넘기기
            if (!visited[x][y]) {
                int reach = arr[x][y];

                for (int i = 0; i < reach; i++) {
                    int nx = x + dx[dir] * i;
                    int ny = y + dy[dir] * i;

                    if (nx < 1 || ny < 1 || nx > N || ny > M) break;

                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        score++;
                        // 연쇄 반응: reach 범위 늘리기
                        reach = Math.max(reach, i + arr[nx][ny]);
                    }
                }
            }

            // 수비
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            visited[sx][sy] = false; // 도미노 세움
        }

        // 결과 출력
        System.out.println(score);
        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= M; b++) {
                System.out.print(visited[a][b] ? "F " : "S ");
            }
            System.out.println();
        }
    }
}
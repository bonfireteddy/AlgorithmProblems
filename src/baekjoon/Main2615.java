package baekjoon;

import java.util.*;
import java.io.*;

public class Main2615 {
    static int[][] board = new int[20][20];
    static int[] dx = {0, 1, 1, -1}; // → ↓ ↘ ↗
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1-based index로 입력
        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 1; x <= 19; x++) {
            for (int y = 1; y <= 19; y++) {
                if (board[x][y] == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int cnt = 1;
                    int nx = x;
                    int ny = y;

                    while (true) {
                        nx += dx[d];
                        ny += dy[d];
                        if (nx < 1 || ny < 1 || nx > 19 || ny > 19) break;
                        if (board[nx][ny] != board[x][y]) break;
                        cnt++;
                        if (cnt > 5) break;
                    }

                    if (cnt == 5) {
                        // 이전 방향에 같은 돌이 있으면 제외 (6개 이상 방지)
                        int px = x - dx[d];
                        int py = y - dy[d];
                        
                        // 여기서 continue에 걸리면 출력문 실행이 안되고 다음 방향 탐색으로 넘어간다.
                        if (px >= 1 && py >= 1 && px <= 19 && py <= 19 && board[px][py] == board[x][y]) continue;

                        System.out.println(board[x][y]);
                        System.out.println(x + " " + y);
                        
                        // 출력하고 프로그램 종료
                        return;
                    }
                }
            }
        }
        
        // 정확히 5개가 안나오거나 그 외의 경우 0 출력
        System.out.println(0);
    }
}

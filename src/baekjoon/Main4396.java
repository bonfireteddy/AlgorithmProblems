package baekjoon;

import java.io.*;

public class Main4396 {
	
	// 지뢰위치있는 지도 보여줄테니까 지금 게임을 진행해놓은 판에서
	// 원래 지뢰위치 고려해서 숫자 적어놔라.
	// 8방향 탐색해서 지뢰몇개있는지 계산해서 적어놓으면 될듯?
	// 그리고 8방향 탐색은 현재 위치의 값이 x인 경우에만 8방향탐색하면 된다.
	// 지뢰가 있는 칸이 열렸다면 지뢰가 있는 모든 칸이 별표(*)로 표시되어야 한다.
	// 즉, 한 배열에서 하는게 아니라 배열을 분리해야한다는걸 알 수 있음.
	// 왜냐면 한가지 배열로 하다가 지뢰가 있는 부분이 덮어씌워질 수 있기 때문
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];       // 지뢰 위치
        char[][] open = new char[N][N];      // 열린 칸
        char[][] result = new char[N][N];    // 출력 결과

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            open[i] = br.readLine().toCharArray();
        }

        boolean gameOver = false;
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (open[i][j] == 'x') {
                    if (map[i][j] == '*') {
                        gameOver = true;
                    }
                    int cnt = 0;
                    for (int d = 0; d < 8; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj] == '*') {
                            cnt++;
                        }
                    }
                    result[i][j] = (char)(cnt + '0');
                } else {
                    result[i][j] = '.';
                }
            }
        }

        // 지뢰를 열었으면 모든 지뢰를 보이게
        if (gameOver) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '*') {
                        result[i][j] = '*';
                    }
                }
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            System.out.println(new String(result[i]));
        }
    }
}

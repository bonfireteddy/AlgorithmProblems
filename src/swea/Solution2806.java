package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution2806 {

    static int N, result;
    static int[] col; // 인덱스 = 행, 값 = 퀸이 놓인 열

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            result = 0;
            col = new int[N];
            dfs(0);
            System.out.printf("#%d %d\n", t, result);
        }
    }

    // 현재 row에 퀸을 놓고 다음 row로 진행
    static void dfs(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            col[row] = i;
            if (isPossible(row)) {
                dfs(row + 1);
            }
        }
    }

    // 이전 퀸들과 충돌하지 않는지 확인
    static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (col[row] == col[i] || Math.abs(row - i) == Math.abs(col[row] - col[i])) {
                return false;
            }
        }
        return true;
    }
}

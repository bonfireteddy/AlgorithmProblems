package baekjoon;

import java.util.*;
import java.io.*;

public class Main17276 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 배열 크기 N (홀수)
            int D = Integer.parseInt(st.nextToken()); // 회전 각도 D

            // 음수 각도 처리 (반시계 방향) -> 양수 각도 (시계 방향)으로 변환
            if (D < 0) {
                D = D + 360; // 예: -45도는 315도와 같음
            }
            int rotations = D / 45; // 45도 단위 회전 횟수

            int[][] arr = new int[N][N]; // 현재 배열 상태
            
            // 배열 입력 받기
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            // 회전 횟수만큼 반복
            for (int k = 0; k < rotations; k++) {
                // 회전 전의 arr 상태를 저장할 임시 배열 (원본 데이터 유지를 위해 필수)
                int[][] temp_arr = new int[N][N];
                for(int r = 0; r < N; r++) {
                    for(int c = 0; c < N; c++) {
                        temp_arr[r][c] = arr[r][c];
                    }
                }

                // 주 대각선을 가운데 열로 이동
                // 주대각: (i, i) -> 가운데 열: (i, N/2)
                for (int i = 0; i < N; i++) {
                    arr[i][N / 2] = temp_arr[i][i];
                }

                // 가운데 열을 부 대각선으로 이동
                // 가운데 열: (i, N/2) -> 부대각: (i, N-1-i)
                for (int i = 0; i < N; i++) {
                    arr[i][N - 1 - i] = temp_arr[i][N / 2];
                }

                // 부 대각선을 가운데 행으로 이동
                // 부대각: (i, N-1-i) -> 가운데 행: (N/2, N-1-i)
                for (int i = 0; i < N; i++) {
                    arr[N / 2][N - 1 - i] = temp_arr[i][N - 1 - i];
                }
                
                // 가운데 행을 주 대각선으로 이동
                // 가운데 행: (N/2, i) -> 주대각: (N/2, i)에서 다시 (N/2, i)로 가는게 아니라
                // 실제 주대각 좌표인 (N/2, N/2)를 기준으로
                // (N/2, i)는 (N-1-i, i)로 가야한다. (헷갈리는 부분)
                // 규칙을 다시 보면, 주대각 (0,0) (1,1) ..
                // 가운데열 (0, N/2) (1, N/2) ..
                // 부대각 (0, N-1) (1, N-2) ..
                // 가운데행 (N/2, 0) (N/2, 1) ..
                //
                // 주대각 (i,i) -> 가운데열 (i, N/2)
                // 가운데열 (i, N/2) -> 부대각 (i, N-1-i)
                // 부대각 (i, N-1-i) -> 가운데행 (N/2, N-1-i)
                // 가운데행 (N/2, i) -> 주대각 (N-1-i, i)
                // 이 마지막 부분이 핵심입니다. 가운데 행의 (N/2, i) 요소는 주대각의 (i,i)로 가는게 아니라, 
                // 원본 배열에서 'i'번째 열에 있는 가운데 행의 요소가 
                // 'i'번째 행에 있는 '주대각선'의 위치로 가는 것입니다.
                // 즉 (N/2, i) -> (i, i)
                for (int i = 0; i < N; i++) {
                    arr[i][i] = temp_arr[N / 2][i];
                }
            }

            // 결과 StringBuilder에 추가
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    sb.append(arr[r][c]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}
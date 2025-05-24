package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2001 {

	// NxN 크기의 정사각형에서 MxM중에 가장 큰 값을 찾는 문제
	// 결국 2차원 배열에서 for문으로 돌면서 현재 값 기준으로 N크기의 영역에
	// 맞게 인덱스를 활용해서 값을 추출한뒤 더하고 최대값변수에 할당
	// 약간 달팽이 문제랑 비슷할지도?
	// 달팽이 문제는 스타트 변수를 만드는게 중요했음

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int arr[][] = new int[N][N];
			
			for (int a = 0; a < N; a++) {
				st = new StringTokenizer(br.readLine());
				for (int b = 0; b < N; b++) {
					arr[a][b] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxValue = 0;

            // 모든 가능한 MxM 영역 탐색
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;

                    // MxM 영역 합산
                    for (int x = 0; x < M; x++) {
                        for (int y = 0; y < M; y++) {
                            sum += arr[i + x][j + y];
                        }
                    }

                    maxValue = Math.max(maxValue, sum);
                }
            }
			
			System.out.printf("#%d %d\n", test_case, maxValue);
		}

	}

}

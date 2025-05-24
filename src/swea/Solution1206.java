package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1206 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 10개의 테스트 케이스
		for (int testCase = 0; testCase < 10; testCase++) {

			int N = Integer.parseInt(br.readLine()); // 건물의 개수 - 부지 너비
			StringTokenizer st = new StringTokenizer(br.readLine()); // 건물의 높이

			int[] buildings = new int[N];

			for (int i = 0; i < N; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}

			int value = 0; // 확보된 세대의 수

			// 2번 건물부터 N-3번 건물까지 조사
			for (int i = 2; i < N - 2; i++) {
				int now = buildings[i];

				// 양옆 두 칸 중 가장 높은 건물 찾기
				int maxNeighbor = Math.max(
					Math.max(buildings[i - 1], buildings[i - 2]),
					Math.max(buildings[i + 1], buildings[i + 2])
				);

				// 현재 건물이 양옆보다 높을 때만 조망권 확보
				if (now > maxNeighbor) {
					value += now - maxNeighbor;
				}
			}

			System.out.printf("#%d %d\n", testCase + 1, value);
		}
	}
}

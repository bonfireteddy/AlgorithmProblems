package baekjoon;

import java.util.*;
import java.io.*;

public class Main11660 {
	// 아니 왜 2,2부터 3,4까지의 합 중에서 3,1의 값이 빠지는건지
	// 이해가 되지 않는다.
	// 알고보니 구하는 영역자체가 직사각형모양의 영역으로 판단됨. 그니까 직사각형 영역에서
	// 좌상단 우하단 꼭지점 좌표를 줬다고 생각하면 된다.
	// 일단 해법은 1,1부터 1,N ...N,N까지 PrefixSum만들어 놓고
	// 해당 구간 나올때마다 그냥 n - n-1해줘서 구간합 구하면 될 것 같다.
	// 1,4에서 2,1로 넘어갈때 구간합을 어케 구하지?

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];
		int[][] prefix = new int[N + 1][N + 1]; // 2차원 누적합

		// 배열 입력 받기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// 2차원 누적합 계산
				prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + arr[i][j];
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int result = prefix[x2][y2]
					   - prefix[x1 - 1][y2]
					   - prefix[x2][y1 - 1]
					   + prefix[x1 - 1][y1 - 1];

			sb.append(result).append('\n');
		}

		System.out.print(sb);
	}
}

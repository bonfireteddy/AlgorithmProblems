package baekjoon;

import java.util.*;
import java.io.*;

public class Main21921 {

	// 주어진 배열에서 길이가 X 구간에서 가장 값이 큰 부분수열을 구하는 문제
	// 근데 그냥 가장 큰 부분수열을 찾고 그게 몇개인지도 찾아야한다.
	// 이거 그냥 누적합 구한 다음에 구간합 x기준으로 뽑아내면 되지않나?
	// 그냥 슬라이딩 윈도우로 완전탐색해서 풀수도 있을 것 같기는 한데, 시간초과일수도?
	// 그리고 x개씩 탐색하면서 구간합 구해서 최대값구하는데 똑같은 값나오면 정답에 1씩 더해주면 될듯

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] prefix = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int a = 1; a <= N; a++) {
			int p = Integer.parseInt(st.nextToken());
			prefix[a] = prefix[a - 1] + p;
		}

		int max = Integer.MIN_VALUE;
		int count = 0;
		for (int a = 1; a <= N - X + 1; a++) {
			int b = a + X - 1;
			int sum = prefix[b] - prefix[a - 1];

			if (sum > max) {
				max = sum;
				count = 1; // 새로 최댓값 갱신되면 count 리셋
			} else if(sum == max) {
				count++; // 기존 최댓값과 같으면 count 증가
			}
		}
		
		if(max == 0) {
			System.out.println("SAD");
		}else {
			System.out.println(max);
			System.out.println(count);
		}
	}
}

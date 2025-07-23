package baekjoon;

import java.util.*;
import java.io.*;

public class Main10815 {

	// 수어진 숫자 카드 M개에 대해서 오름차순으로 정렬한다음 이분탐색을 적용한다.
	// left 0부터 right M-1에 대해서 mid구하는 방식으로
	// 그리고 주어진 N에 대해서 M구간의 mid와 비교해서 작으면 왼쪽 크면 오른쪽구간을 반복

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] mine = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int a = 0; a < N; a++) {
			mine[a] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int[] nums = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int a = 0; a < M; a++) {
			nums[a] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(mine); // 상근이 카드 오름차순 정렬

		int[] results = new int[M]; // 기본값은 0

		for (int a = 0; a < M; a++) {
			int num = nums[a]; // 주어진 카드 요소
			int left = 0;
			int right = N - 1;
			
			while (left <= right) {
				int midIndex = (left + right) / 2;
				int mid = mine[midIndex];
				
				if (mid > num) {
					right = midIndex - 1;
				} else if (mid < num) {
					left = midIndex + 1;
				} else { // 찾았을때
					results[a] = 1;
					break;
				}
			}
		}
		
		
		for(int a = 0; a < M; a++) {
			System.out.print(results[a] + " ");
		}

	}

}

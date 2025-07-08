package baekjoon;

import java.util.*;
import java.io.*;

public class Main21921 {

	// 주어진 배열에서 길이가 X 구간에서 가장 값이 큰 부분수열을 구하는 문제
	// 근데 그냥 가장 큰 부분수열을 찾고 그게 몇개인지도 찾아야한다.
	// 이거 그냥 누적합 구한 다음에 구간합 x기준으로 뽑아내면 되지않나?
	// 그냥 슬라이딩 윈도우로 풀 수도 있다.
	// 그리고 x개씩 탐색하면서 구간합 구해서 최대값구하는데 똑같은 값나오면 정답에 1씩 더해주면 될듯

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int a = 0; a < N; a++) {
			int p = Integer.parseInt(st.nextToken());
			arr[a] = p;
		}
		
		// 가장 첫 구간의 합을 미리 구해놓는다.
		int sum = 0;
		for(int a = 0; a < X; a++) {
			sum += arr[a];
		}
		
		// 초기 구간도 최대값 후보에 포함
		int max = sum;
		int count = 1;
		
		int i = 0;
		int j = X;
		while(j < N) {
			sum = sum - arr[i] + arr[j]; // 윈도우를 한 칸 이동
			
			if(max == sum) count++;
			else if(max < sum) {
				max = Math.max(max, sum);
				count = 1;
			}
			
			i++;
			j++;
		}
		
		if(max == 0) {
			System.out.println("SAD");
		}else {
			System.out.println(max);
			System.out.println(count);
		}
	}
}

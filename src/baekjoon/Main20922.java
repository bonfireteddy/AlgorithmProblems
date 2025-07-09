package baekjoon;

import java.util.*;
import java.io.*;

public class Main20922 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int a = 0; st.hasMoreTokens(); a++) {
			int num = Integer.parseInt(st.nextToken());
			arr[a] = num;
		}
		
		int[] nums = new int[200_001]; // 여기에 입력된 번호 등장 횟수 저장
		int left = 0, maxLen = 0;
		
		for(int right = 0; right < N; right++) {
			int x = arr[right]; // 입력된 숫자
			nums[x]++; // 입력된 숫자를 인덱스로 활용해서 등작횟수 카운팅
			
			while(nums[x] > K) { // K보다 많이 등장한 경우에 조건에 걸림
				nums[arr[left]]--; // 입력된 숫자x가 K보다 적게 등장할 때까지 왼쪽 숫자는 부분배열에서 제외
				left++; // 왼쪽을 땡기면서 슬라이딩 윈도우
			}
			
			maxLen = Math.max(maxLen, right - left + 1); // 0부터 시작하기 때문에 +1해주기
		}
		
		System.out.println(maxLen);
	}
}

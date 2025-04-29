package java1244;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int changeCount;
	static int maxValue;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= testCase; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			String value = st.nextToken();
			changeCount = Integer.parseInt(st.nextToken());
			arr = new int[value.length()];
			
			for(int i = 0; i < value.length(); i++) {
				arr[i] = value.charAt(i) - '0';
			}
		
			// 최적화 부분
			// 숫자가 3개인데 교환 기회가 10번이면
			// 똑같은 패턴만 계속 나오기 때문에 
			// 굳이 10번 다 안하고 3번정도만 바꿔도 모든 경우가 다 나온다.
			// 그럼 숫자가 6개인 경우에 모든 경우의 수가 다 나오는 건 몇개지? 
			if (arr.length < changeCount) {
				changeCount = arr.length;
            }
			
			dfs(0, 0);
			
			System.out.printf("#%d %s\n", test_case, maxValue);
			maxValue = 0;
		}

	}
	
	public static void dfs(int start, int count) {
		
		// 종료 조건
		if(count == changeCount) {
			// 배열을 숫자로 변환
			int num = 0;
			for(int i = 0; i < arr.length; i++) {
				num = num * 10 + arr[i];
				// 숫자 배열을 정수로 만드는 공식
			}
			maxValue = Math.max(maxValue, num);
			return;
		}
		
		// 재귀 탐색 DFS 본체
		int n = arr.length;
		for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                swap(i, j);
                dfs(i, count + 1);
                swap(i, j); // 다시 원복
            }
        }
		
		// 단순히 원래 배열로 되돌리고 가지치기는 적용안됨.
		// 배열을 효율적으로 사용하기 위한 목적
	}
	
	public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
}

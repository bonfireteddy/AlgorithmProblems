package java1859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	// 주어진 입력에서 최대수를 찾아내는 건 했는데 이게 토큰을 사용해서 그런가
	// 이전 매매가가 저장이 돼있어야 최대매매가에서 나머지 매매가를 빼고
	// 더할 수 있는데 어떻게 이전 매매가들을 저장해야하지?
	// 아니면 매매가이니까 산물건의 개수랑 단가식으로 저장해야하나?
	// 그리고 최대매매가 이후에는 다시 최대매매가를 찾고 거기서 물건들을 
	// 팔아나가는 식으로 짜야할 것 같다.
	// 그냥 배열 사용해보자
	
	// 주어진 매매가에서 최대 매매가를 찾는다.
	// 찾은 최대 매매가가 가장 첫번째 날이고 날이 갈수록 점점 매매가가 낮아지기만 하면
	// 애초에 사는 것 자체가 손해이기 때문에 아무것도 사지 않는 것이 최대 이익이다. 따라서 이익은 0
	// 우선 최대 매매가를 찾아서 최대 매매가 이전 날들 매매가를 전부 산다. 그리고 최대매매날에 수량을 전부 판다.
	// 최대 매매가가 더이상 없지만 다음 날들 중에서 최대 매매가를 구하고 또 이전 날들 중에
	// 최대매매가보다 낮은날을에 다 매수한다. 그리고 최대 매매가날에 판다.
	
	// 인덱스부분을 잘 조정하는 것에 대해 유의하자
	// 자료형 크기를 잘 확인해야한다.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] profits = new long[T];
		
		for(int a = 0; a < T; a++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 매매가 배열 저장
			int arr[] = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			long maxProfit = 0;
			int idx = 0;
			
			while(idx < N) {
				// 1. 현재 구간에서 최대값과 그 인덱스 찾기
				int max = arr[idx];
				int maxIndex = idx;
				for(int i = idx; i < N; i++) {
					if(arr[i] > max) {
						max = arr[i];
						maxIndex = i;
					} 
				}
				
				// 2. maxIndex까지의 차익 계산
				for(int i = idx; i < maxIndex; i++) {
					maxProfit += max - arr[i];
				}
				
				// 3. 다음 구간 탐색을 위해 인덱스 이동
				idx = maxIndex + 1;
			}
			
			profits[a] = maxProfit;
		}
		
		for(int a = 1; a <= T; a++) {
			System.out.println("#"+a+" "+profits[a-1]);
		}

	}

}

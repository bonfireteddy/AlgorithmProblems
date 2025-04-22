package java1859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int a = 0; a < T; a++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int maxToken;
			for(int i = 0; i < N; i++) {
				int firstToken = Integer.parseInt(st.nextToken());
				int secondToken = Integer.parseInt(st.nextToken());
				
				if(firstToken < secondToken) {
					maxToken = secondToken;
				} 
			}
			
			// 주어진 입력에서 최대수를 찾아내는 건 했는데 이게 토큰을 사용해서 그런가
			// 이전 매매가가 저장이 돼있어야 최대매매가에서 나머지 매매가를 빼고
			// 더할 수 있는데 어떻게 이전 매매가들을 저장해야하지?
			// 아니면 매매가이니까 산물건의 개수랑 단가식으로 저장해야하나?
			// 그리고 최대매매가 이후에는 다시 최대매매가를 찾고 거기서 물건들을 
			// 팔아나가는 식으로 짜야할 것 같다.
			// 그냥 배열 사용해보자
		}

	}

}

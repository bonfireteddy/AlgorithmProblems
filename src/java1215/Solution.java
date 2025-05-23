package java1215;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	// 일단 문제만 봐서는 완전탐색인것같은데.
	// 회문은 첫번째칸과 마지막칸에서 좁혀가면서 계속 같으면 회문 O
	// 회문은 요소가 3개이상일때부터 성립, 따라서 
	// 1-3,1-4,..1-N하다가 2-N,3-N,4-N 이렇게 다 확인해야한다.
	// N이 찾아야하는 회문길이이기 때문에 1-N,2-(N+1),.. 이렇게 뻗기만하면 될듯
	// 위 방식으로 가로세로줄 전부하면 완전탐색완료
	
	public static void main(String[] args) throws IOException{
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			
			int result = 0; // 회문의 개수
			
			// 찾아야 하는 회문의 길이
			int N = Integer.parseInt(br.readLine());
			String[][] arr = new String[8][8];
			
			for(int a = 0; a < 8; a++) {
				String line = br.readLine();
				for(int b = 0; b < 8; b++) {
					arr[a][b] = String.valueOf(line.charAt(b));
				}
			}
			
			List<String> CurrentList = new ArrayList<>();
			
			// 8x8 반복
			for(int a = 0; a < 8; a++) { // 세로줄
				
				for(int b = 0; b <= 8-N; b++) { // 가로줄 탐색횟수
					CurrentList = new ArrayList<>();
					for(int i = b; i < N+b; i++) { // 횟수마다 N개씩탐색
						CurrentList.add(arr[a][i]);
					}
					
					for(int i = 0; i < N; i++) {
						//System.out.print(CurrentList.get(i)+" ");
					}	
					
					boolean check = true;
					// 팰린드롬이 맞는지 확인
					for(int p = 0; p < N/2; p++) {
						String f = CurrentList.get(p);
						String e = CurrentList.get(CurrentList.size()-p-1);
						if(!f.equals(e)) {
							check = false;
						}
					}
					
					if(check) {
						result++; // 맞으면 result에 ++
					}
					//System.out.println();
				}
				
			}
			
			// 8x8 반복
			for(int a = 0; a < 8; a++) { // 세로줄
				
				for(int b = 0; b <= 8-N; b++) { // 가로줄 탐색횟수
					CurrentList = new ArrayList<>();
					for(int i = b; i < N+b; i++) { // 횟수마다 N개씩탐색
						CurrentList.add(arr[i][a]);
					}
					
					for(int i = 0; i < N; i++) {
						//System.out.print(CurrentList.get(i)+" ");
					}	
					
					boolean check = true;
					// 팰린드롬이 맞는지 확인
					for(int p = 0; p < N/2; p++) {
						String f = CurrentList.get(p);
						String e = CurrentList.get(CurrentList.size()-p-1);
						if(!f.equals(e)) {
							check = false;
						}
					}
					
					if(check) {
						result++; // 맞으면 result에 ++
					}
					//System.out.println();
				}
				
			}
			
			System.out.printf("#%d %d\n", t, result);
		}
	}

}

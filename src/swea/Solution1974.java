package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution1974 {
	// 2차원 배열만들고 x열 y열 순으로 전부 다 탐색
	// 3x3블록 9개 순서대로 탐색
	// 중요한건 숫자 9개 중에 겹치는게 있는지 없는지 탐색하는게 중요할듯?
	static int arr[][] = new int[9][9];
	
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			int result = 1;
			
			for (int a = 0; a < 9; a++) {
				String[] tokens = br.readLine().split(" ");
				for (int b = 0; b < 9; b++) {
					arr[a][b] = Integer.parseInt(tokens[b]);
				}
			}
			
			// 가로 1~9 확인
			for (int a = 0; a < 9 && result == 1; a++) {
				Set<Integer> set = new HashSet<>();
				for (int b = 0; b < 9; b++) {
					if (set.contains(arr[a][b])) {
						result = 0;
				        break;
				    }
				    set.add(arr[a][b]);
				}
			}
			
			// 3x3 1~9 확인
			for (int w = 0; w < 3 && result == 1; w++) {
				for (int t = 0; t < 3 && result == 1; t++) {
					Set<Integer> set = new HashSet<>();
					//3x3블럭
					for (int a = 3*w; a < 3+(3*w); a++) {
						for (int b = 3*t; b < 3+(3*t); b++) {
							// 중복확인을 set으로 처리하기
							if (set.contains(arr[a][b])) {
								result = 0;
						        break;
						    }
						    set.add(arr[a][b]);
						}
					}
					
				}
			}
			
			// 세로 1~9 확인
			for (int a = 0; a < 9 && result == 1; a++) {
				Set<Integer> set = new HashSet<>();
				
				for (int b = 0; b < 9; b++) {
					if (set.contains(arr[b][a])) {
						result = 0;
				        break;
				    }
				    set.add(arr[b][a]);
				}
			}
			
			System.out.printf("#%d %d\n", test_case, result);
		}

	}

}

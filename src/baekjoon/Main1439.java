package baekjoon;

import java.util.*;
import java.io.*;

public class Main1439 {
	
	// 문자는 1하고 0만 주어지고 모든 숫자를 전부 같게 만드는 최소 횟수구하기
	// 계속 탐색하면서 현재문자가 이전 문자랑 같은 값이면 지나가고 다른 값이 나오면 
	// 다시 또 다른 값이 나올때까지 뒤집는다. 근데 이러면 0을 뒤집는 경우랑 1을 뒤집는 경우
	// 둘다 해야 최소 횟수를 구할 수 있는데, 한번에 하는 좋은 방법 없나?
	
	// 일단 1에서 0으로 바뀌는 경우+1이 마지막인 경우 랑 0에서 1로 바뀌는 경우의 개수+0이 마지막인 경우를 센다.
	// 둘중에서 첫번째 경우이면 1을 0으로 바꾸고 두번째 경우이면 0을 1로 바꾼다.
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		char[] arr = new char[str.length()];
		
		for(int a = 0; a < arr.length; a++) {
			arr[a] = str.charAt(a);
		}
		
		int check0 = 0; // 1에서 0이 되는 경우 
		int check1 = 0; // 0에서 1이 되는 경우 + 0이 마지막인 경우
		for(int a = 0; a < arr.length-1; a++) {
			if(arr[a] == '1' && arr[a] != arr[a+1]) {
				check0++;
			}else if(arr[a] == '0' && arr[a] != arr[a+1]) {
				check1++;
			}
		}
		
		if(arr[arr.length-1] == '1') { // 1이 마지막인 경우
			check0++;
		}else if(arr[arr.length-1] == '0' ) { // 0이 마지막인 경우
			check1++;
		}
		int result = Math.min(check0, check1);
		System.out.println(result);
	}

}

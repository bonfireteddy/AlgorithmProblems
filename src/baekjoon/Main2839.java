package baekjoon;

import java.util.*;
import java.io.*;

public class Main2839 {
	
	// 3과 5로 N을 만들어야할때 최소개수를 구하는 것이다.
	// 정확하게 N을 만들 수 없을 경우는 -1을 출력
	// N을 5로 먼저 나눈다음 3으로 나누고 이거 안되면
	// 3으로만 해보면 되는거 아닌가? 이게 실버4문제?
	// 5로 딱 맞아떨어지는 경우
	// 5로 좀 되다가 3으로 되는 경우
	// 5로 좀 되다가 3으로 안되는 경우
	// 5의 최대개수로 안돼서 5최대개수 -1하고 3으로 되는 경우 안되는 경우
	// 3으로 딱 맞아 떨어지는 경우
	// 5로도 안되고 5하고 3으로도 안되고 3으로도 안되는 경우는 -1
	
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count = 0;

		while (N >= 0) {
		    if (N % 5 == 0) {
		        count += N / 5;
		        System.out.println(count);
		        return; // 정답을 찾았으니 종료
		    }
		    N -= 3;
		    count++;
		}

		// 루프 끝났는데도 못 만들면 -1
		System.out.println(-1);
		
	}
}

package baekjoon;

import java.util.*;
import java.io.*;

public class Main1931 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 회의를 저장할 배열
        int[][] meetings = new int[N][2];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }
        
        // 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의
        Arrays.sort(meetings, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		// 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
        		if(o1[1] == o2[1]) {
        			return o1[0] - o2[0];
        		}
        		
        		return o1[1] - o2[1];
        	}
        });
        
        // 종료 시간 오름차순 정렬 (종료 시간이 같으면 시작 시간 오름차순)
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        int count = 0;       // 최대 회의 수
        int lastEnd = 0;     // 마지막으로 선택된 회의의 종료 시간

        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= lastEnd) {
                // 현재 회의의 시작 시간이 마지막 회의 종료 시간 이후이면 선택
                lastEnd = meetings[i][1];
                count++;
            }
        }

        System.out.println(count);
		
	}

}

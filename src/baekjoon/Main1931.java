package baekjoon;

import java.util.*;
import java.io.*;

public class Main1931 {
	
	// 정렬 조건이 2개가 있는 것 같다.
	// 시작시간 기준으로 정렬하고 회의시간이 가장 적은걸 먼저 선택한다.
	
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

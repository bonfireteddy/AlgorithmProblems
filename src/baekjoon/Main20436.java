package baekjoon;

import java.util.*;
import java.io.*;

public class Main20436 {

	// 각 알파벳 키의 자판 위치를 저장하는 맵 (문자 → [행, 열])
	static Map<Character, int[]> keyMap = new HashMap<>();

	// 왼손으로 타이핑하는 키 집합
	static Set<Character> leftKeys = new HashSet<>(
			Arrays.asList('q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v'));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 자판의 각 키 위치 설정 (row, col 기준으로)
		setKeyboard();

		// 왼손 시작 위치, 오른손 시작 위치 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		char left = st.nextToken().charAt(0); // 왼손 시작 위치
		char right = st.nextToken().charAt(0); // 오른손 시작 위치

		// 입력해야 할 문자열
		String input = br.readLine();

		int time = 0; // 전체 걸리는 시간

		// 입력할 각 문자를 순회하면서 처리
		for (char ch : input.toCharArray()) {
			int[] nextPos = keyMap.get(ch); // 다음 입력할 키의 위치

			// 왼손으로 입력하는 키인 경우
			if (leftKeys.contains(ch)) {
				time += distance(keyMap.get(left), nextPos) + 1; // 거리 + 1초(입력 시간)
				left = ch; // 왼손 위치 업데이트
			}
			// 오른손으로 입력하는 키인 경우
			else {
				time += distance(keyMap.get(right), nextPos) + 1; // 거리 + 1초(입력 시간)
				right = ch; // 오른손 위치 업데이트
			}
		}

		// 총 걸린 시간 출력
		System.out.println(time);
	}

	// 자판상의 각 문자 위치를 행(row), 열(col)로 맵에 저장
	static void setKeyboard() {
		String[] keys = { "qwertyuiop", // 0번째 줄
				"asdfghjkl", // 1번째 줄
				"zxcvbnm" // 2번째 줄
		};

		for (int i = 0; i < keys.length; i++) {
			for (int j = 0; j < keys[i].length(); j++) {
				char ch = keys[i].charAt(j);
				keyMap.put(ch, new int[] { i, j }); // 각 키의 위치 저장
			}
		}
	}

	// 두 키 위치 간의 거리 계산 (맨해튼 거리)
	static int distance(int[] pos1, int[] pos2) {
		return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
	}

}

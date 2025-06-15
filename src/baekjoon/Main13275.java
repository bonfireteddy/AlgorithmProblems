package baekjoon;

import java.util.*;
import java.io.*;

public class Main13275 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 1. 문자열 전처리: # 삽입 (예: "abba" → "#a#b#b#a#")
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (char c : input.toCharArray()) {
            sb.append(c).append('#');
        }
        String s = sb.toString();

        int[] p = new int[s.length()]; // 각 위치에서의 최대 반지름
        int center = 0, right = 0;
        int maxLen = 0;

        // 2. Manacher's Algorithm 메인 루프
        for (int i = 0; i < s.length(); i++) {
            // i가 현재 팰린드롬의 오른쪽 경계를 벗어나지 않았다면, 좌우 대칭되는 값 활용
            int mirror = 2 * center - i; // i의 대칭 위치

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // 양쪽으로 확장
            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < s.length() &&
                   s.charAt(i - p[i] - 1) == s.charAt(i + p[i] + 1)) {
                p[i]++;
            }

            // 확장된 결과가 오른쪽 끝을 넘으면 중심 갱신
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // 최대 길이 저장
            maxLen = Math.max(maxLen, p[i]);
        }

        System.out.println(maxLen);
    }

}

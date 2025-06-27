package baekjoon;

import java.io.*;
import java.util.*;

public class Main5639 {
    static List<Integer> preorder = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void postOrder(int start, int end) {
        if (start >= end) return;

        int root = preorder.get(start);
        int idx = start + 1;

        // 왼쪽 서브트리: 루트보다 작은 값들
        while (idx < end && preorder.get(idx) < root) {
            idx++;
        }

        // 왼쪽 탐색
        postOrder(start + 1, idx);
        // 오른쪽 탐색
        postOrder(idx, end);
        // 루트 출력
        sb.append(root).append('\n');
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            preorder.add(Integer.parseInt(line));
        }

        postOrder(0, preorder.size());
        System.out.print(sb);
    }
}

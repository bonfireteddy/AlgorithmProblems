package baekjoon;

import java.util.*;
import java.io.*;

public class Main2263 {
	
	static int N;
    static int[] inorder;
    static int[] postorder;
    static int[] position; // inorder 위치 빠르게 찾기
    static StringBuilder sb = new StringBuilder();

    public static void buildTree(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        int root = postorder[postEnd];
        sb.append(root).append(" ");

        int rootIndex = position[root]; // inorder에서 루트 인덱스 찾기
        int leftSize = rootIndex - inStart;

        // 왼쪽 서브트리
        buildTree(inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
        // 오른쪽 서브트리
        buildTree(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        inorder = new int[N];
        postorder = new int[N];
        position = new int[100_001]; // 값이 최대 100,000까지 주어짐
        // // 언더스코어 있음 → 가독성 좋음

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            position[inorder[i]] = i; // 값 → 인덱스 맵핑
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        buildTree(0, N - 1, 0, N - 1);

        System.out.println(sb.toString());
    }

}

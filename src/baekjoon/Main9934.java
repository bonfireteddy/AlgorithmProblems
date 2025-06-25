package baekjoon;

import java.util.*;
import java.io.*;

public class Main9934 {
	
	// 이진트리에서 중위순회로 순서를 구하는 문제
	// 근데 트리는 어떻게 만들고 중위순회는 코드가 뭐였더라?
	// 자료구조 시간에 확실히 배웠음.
	// 근데 이게 중위순회 순서대로 입력으로 받은 것들로 완전 이진 트리를 만든다음에 
	// 출력은 레벨 순 즉, 레벨순회인데, 이건 BFS로 출력하면 되겠다.
	
	static int K; // 트리의 깊이
	static int N; // 총 노드 수
	static int[] inorderArr; // 중위 순회 입력 배열
	static List<Integer>[] resultLevels; // 각 레벨별 노드를 저장할 리스트 배열
	
	static StringBuilder inorderSB = new StringBuilder();
    static StringBuilder preorderSB = new StringBuilder();
    static StringBuilder postorderSB = new StringBuilder();
    static StringBuilder levelorderSB = new StringBuilder();
	/**
     * 중위 순회 배열을 이용하여 트리를 구축하고 노드를 레벨별로 분류하는 재귀 함수
     * @param start 현재 서브트리 중위 순회 시작 인덱스
     * @param end 현재 서브트리 중위 순회 끝 인덱스
     * @param depth 현재 노드의 깊이 (0이 루트)
     */
	static void traverse(int start, int end, int type, int depth) {
		if(start > end) { // 기저 사례: 서브트리가 비어있을 경우
			return;
		}
		
		int mid = (start + end) / 2; // 현재 서브트리의 루트 노드는 항상 가운데 위치
		
		if (type == 1) preorderSB.append(inorderArr[mid]).append(" "); // 전위
        else if (type == 3)resultLevels[depth].add(inorderArr[mid]); // 해당 깊이의 리스트에 루트 노드 추가
		
		
		traverse(start, mid-1, type, depth+1); // 왼쪽 서브트리 재귀 호출
		 if (type == 0) inorderSB.append(inorderArr[mid]).append(" ");  // 중위
		traverse(mid+1, end, type, depth+1); // 오른쪽 서브트리 재귀 호출
		if (type == 2) postorderSB.append(inorderArr[mid]).append(" ");  // 후위
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		K = Integer.parseInt(br.readLine());
		
		N = (int)Math.pow(2, K)-1; // 완전 이진 트리의 총 노드 수 = 2^K-1;
		
		inorderArr = new int[N];
		
		// 각 레벨별 리스트 초기화
		resultLevels = new ArrayList[K]; // K는 트리의 깊이(0부터 K-1까지)
		
		for(int i = 0; i < K; i++) {
			resultLevels[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int a = 0; a < N; a++) {
			inorderArr[a] =  Integer.parseInt(st.nextToken());
		}
		
		// 중위 순회 (그대로 출력됨)
		traverse(0, N-1, 0, 0); // (시작 인덱스, 끝 인덱스, 순회타입, 현재 깊이)
		
		// 전위 순회
		traverse(0, N-1, 1, 0); // (시작 인덱스, 끝 인덱스, 순회타입, 현재 깊이)
		
		// 후위 순회
		traverse(0, N-1, 2, 0); // (시작 인덱스, 끝 인덱스, 순회타입, 현재 깊이)
		
		// 레벨 순회
		traverse(0, N-1, 3, 0); // (시작 인덱스, 끝 인덱스, 순회타입, 현재 깊이)
		
		// 결과 출력
		bw.write(inorderSB.toString()+ "\n");
		bw.write(preorderSB.toString()+ "\n");
		bw.write(postorderSB.toString()+ "\n");
		
		for(int i = 0; i < K; i++) {
			for(int node : resultLevels[i]) {
				levelorderSB.append(node).append(" ");
			}
			levelorderSB.append("\n");
		}
		bw.write(levelorderSB.toString()+ "\n");
		
		bw.flush();
	}
}

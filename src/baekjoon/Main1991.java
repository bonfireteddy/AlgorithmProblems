package baekjoon;

import java.util.*;
import java.io.*;

public class Main1991 {
	
	// 인접리스트로 이진 트리 구성 입력 받고
	// 나머지는 순회하는 코드로 구성
	// int일때는 인덱스로 바로 접근하는게 가능 했는데, String일때는 어떻게 해야하지?
	// 아니면 그냥 리스트배열에다가 3개 다 넣고 0,1,2로 접근해야하나?
	// 아니면 Map으로 키만들어서 해야하나? Map으로 만드는 이진트리?
	// 일단 리스트배열로 진행해보자
	
	static List<String>[] listArr;
	static int N;
	static StringBuilder preSb = new StringBuilder();
	static StringBuilder inSb = new StringBuilder();
	static StringBuilder postSb = new StringBuilder();
	
	public static void binaryTreeTraversal(String start, int type) {
		if(start.equals(".")) {
			return;
		}
		
		int input = 0;
		for(int a = 0; a < N; a++){
			if(listArr[a].get(0).equals(start)) {
				input = a;
			}
		}
		
		if(type == 0) preSb.append(listArr[input].get(0)); 
		binaryTreeTraversal(listArr[input].get(1), type); // 왼쪽 노드 탐색
		if(type == 1)  inSb.append(listArr[input].get(0)); 
		binaryTreeTraversal(listArr[input].get(2), type); // 오른쪽 노드 탐색
		if(type == 2)  postSb.append(listArr[input].get(0)); 
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		listArr = new ArrayList[N]; // 리스트 배열 초기화
		for(int a = 0; a < N; a++) {
			listArr[a] = new ArrayList<>();
		}
		
		for(int a = 0; a < N; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
				listArr[a].add(st.nextToken()); // 0이 부모노드
				listArr[a].add(st.nextToken()); // 1이 왼쪽 자식 노드
				listArr[a].add(st.nextToken()); // 2가 오른쪽 자식 노드
		}
		
		binaryTreeTraversal("A", 0); // 전위 순회
		binaryTreeTraversal("A", 1); // 중위 순회
		binaryTreeTraversal("A", 2); // 후위 순회
		
		bw.write(preSb.toString()+"\n");
		bw.write(inSb.toString()+"\n");
		bw.write(postSb.toString()+"\n");
		bw.flush();
		
	}

}

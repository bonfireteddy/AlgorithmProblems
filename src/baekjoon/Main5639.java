package baekjoon;

import java.util.*;
import java.io.*;

public class Main5639 {
	
	// 이진 검색 트리라서 노드보다 작은 건 왼쪽, 큰건 오른쪽에 들어감
	// 문제에서 전위순회 순서대로 입력으로 들어오는데, 이거 가지고 
	// 후위순회한 순서를 출력하라고 한다.
	// 근데 저번에 이진트리에서는 전위순회나 중위순회 순서를 알아야지
	// 나머지 순회 순서를 알 수 있는데, 그게 이진검색트리에서도 똑같은지는 모르겠음
	// 근데 이진 검색트리가 트리를 오름차순으로 정렬한게 중위순회랑 똑같아서
	// 혹시 전위순회랑 이 중위순회를 이용해서 전에 풀었던 것처럼
	// 전위순회로 맨앞에서 노드찾고 중위순회에서 인덱스 찾아서 왼쪽 서브트리
	// 오른쪽 서브트리 반갈해서 탐색하는 식으로 해야하나?
	
	static List<Integer> preList = new ArrayList();
	static List<Integer> inList= new ArrayList();
	static StringBuilder postSb = new StringBuilder();
	static int N;
	
	static void buildTree(int preStart, int preEnd, int inStart, int inEnd) {
		if(preStart > preEnd || inStart > inEnd) return;
		
		int root = preList.get(preStart); // preorder의 첫번째 노드는 루트노드
		int mid = 0;
		int count = 0;
		for(int v : inList) { // 중위순회에서 root 인덱스 찾기
			if(root == v){
				mid = count;
			}
			count++;
		}
		
		int leftSize = mid - inStart; // 왼쪽 서브트리 크기
		
		// 왼쪽 서브트리
		buildTree(preStart+1, preStart + leftSize, inStart, mid-1);
		
		// 오른쪽 서브트리
		buildTree(preStart + leftSize + 1, preEnd, mid+1, inEnd);
		postSb.append(root + "\n");
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input;
		int count = 0;
		// 전위순회 순서 입력받기
		while((input = br.readLine()) != null && !input.isEmpty()) {
			preList.add(Integer.parseInt(input));
			inList.add(Integer.parseInt(input));
			count++;
		}
		
		N = count;
		// 오름차순 정렬 -> 중위순회 순서 등장 이진 검색 트리 특징
		Collections.sort(inList);
		
		// 전위순회와 중위순회를 가지고 루트찾고 서브트리 중심찾기
		buildTree(0, N-1, 0, N-1);
		
		bw.write(postSb.toString());
		bw.flush();
	}

}

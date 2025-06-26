package baekjoon;

import java.util.*;
import java.io.*;

public class Main1068 {
	
	// 이진 트리에서 지울노드 선택해서 지워버리고  트리 순회 하면서 빌드트리함수에서
	// if로 재귀 끊는 부분에서 카운트해서 리프노드 개수 새면 될듯?
	// 트리는 노드 클래스 만들어서도 가능하고 리스트배열로도 될 것 같은데
	// 지울 노드의 번호화 같은 인덱스자리 값을 -1로 변경하고 지울 노드의 번호와 같은
	// 값들을 -1로 변경한다. 그리고 빌드트리함수는 처음 발견된 0번 인덱스와 -1을 제외한 나머지
	// -1인 경우에 if문 조건에서 return한다.
	
	static int[] arr;
	static int N, R;
	static int count = 0;
	
	static void buildTree(int current) {
		boolean hasChild = false;
		
		for(int a = 0; a < N; a++) {
			if(arr[a] == current && a != R) {// 삭제 노드가 아닌 자식 노드만 탐색
				hasChild = true;
				buildTree(a);
			}
		}
		
		// 자식이 없으면 리프 노드
		if(!hasChild) count++;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int a = 0; a < N; a++) {
			arr[a] = Integer.parseInt(st.nextToken());
		}
		
		R = Integer.parseInt(br.readLine());
		
		// 부모가 -1인 루트노드의 인덱스 찾기
		int root = -1;
		for (int i = 0; i < N; i++) {
		    if (arr[i] == -1 && i != R) {
		        root = i;
		        break;
		    }
		}
		
		// 리프 노드의 개수 출력
		if (R == root) {
			bw.write(0);
        } else {
            buildTree(root);
            bw.write(count + "\n");
            // bw.write(String.valueOf(count));
        }
		
		bw.flush();
	}

}

package baekjoon;

import java.util.*;
import java.io.*;

public class Main11725 {

	static int N;
	static List<Integer>[] adj;
	static int[] parent;
	static boolean[] visited;

	static void dfs(int current) {
		visited[current] = true;

		for (int next : adj[current]) {
			if (!visited[next]) {
				parent[next] = current;
				dfs(next);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		adj = new ArrayList[N + 1];
		parent = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adj[u].add(v);
			adj[v].add(u);
		}

		dfs(1); // 루트 노드 1부터 탐색

		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}
}

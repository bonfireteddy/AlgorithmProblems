package baekjoon;

import java.io.*;
import java.util.*;

public class Main13549 {
    static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        int[] time = new int[MAX + 1];
        Arrays.fill(time, -1); // 방문하지 않은 곳은 -1

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(N);
        time[N] = 0;

        while (!dq.isEmpty()) {
            int cur = dq.poll();

            if (cur == K) break;

            // 순간이동 (가중치 0 → addFirst)
            if (cur * 2 <= MAX && time[cur * 2] == -1) {
                time[cur * 2] = time[cur];
                dq.addFirst(cur * 2);
            }

            // 걷기 (가중치 1 → addLast)
            for (int next : new int[]{cur - 1, cur + 1}) {
                if (next >= 0 && next <= MAX && time[next] == -1) {
                    time[next] = time[cur] + 1;
                    dq.addLast(next);
                }
            }
        }

        System.out.println(time[K]);
    }
}


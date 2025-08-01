package baekjoon;

import java.io.*;
import java.util.*;

public class Main19637 {
    static class Title {
        String name;
        int power;

        Title(String name, int power) {
            this.name = name;
            this.power = power;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 칭호 수
        int M = Integer.parseInt(st.nextToken()); // 캐릭터 수

        Title[] titles = new Title[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            titles[i] = new Title(name, power);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int q = Integer.parseInt(br.readLine());

            int left = 0, right = N - 1, res = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (q <= titles[mid].power) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            sb.append(titles[res].name).append("\n");
        }

        System.out.println(sb);
    }
}

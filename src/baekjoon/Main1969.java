package baekjoon;

import java.util.*;
import java.io.*;

public class Main1969 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // DNA 수
        int M = Integer.parseInt(st.nextToken()); // 문자열 길이

        String[] dna = new String[N];
        for (int i = 0; i < N; i++) {
            dna[i] = br.readLine();
        }

        StringBuilder result = new StringBuilder();
        int totalDistance = 0;

        char[] bases = {'A', 'C', 'G', 'T'};

        for (int pos = 0; pos < M; pos++) {
            int[] count = new int[4]; // A, C, G, T

            for (int i = 0; i < N; i++) {
                char c = dna[i].charAt(pos);
                if (c == 'A') count[0]++;
                else if (c == 'C') count[1]++;
                else if (c == 'G') count[2]++;
                else if (c == 'T') count[3]++;
            }

            int max = -1;
            int idx = 0;
            for (int i = 0; i < 4; i++) {
                if (count[i] > max) {
                    max = count[i];
                    idx = i;
                }
            }

            result.append(bases[idx]);

            for (int i = 0; i < N; i++) {
                if (dna[i].charAt(pos) != bases[idx]) {
                    totalDistance++;
                }
            }
        }

        System.out.println(result);
        System.out.println(totalDistance);
    }
}

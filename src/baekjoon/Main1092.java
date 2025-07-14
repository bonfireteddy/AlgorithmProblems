package baekjoon;

import java.util.*;
import java.io.*;

public class Main1092 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) cranes[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) boxes.add(Integer.parseInt(st.nextToken()));

        Arrays.sort(cranes, Collections.reverseOrder());         // 내림차순
        boxes.sort(Collections.reverseOrder());                  // 내림차순

        if (boxes.get(0) > cranes[0]) { // 가장 센 크레인보다 무거운 박스가 있으면 불가능
            System.out.println(-1);
            return;
        }

        int minutes = 0;
        while (!boxes.isEmpty()) {
            int boxIdx = 0;
            for (int i = 0; i < N;) {
                if (boxIdx >= boxes.size()) break;
                if (cranes[i] >= boxes.get(boxIdx)) {
                    boxes.remove(boxIdx); // 이건 O(1)
                    i++;
                } else {
                    boxIdx++;
                }
            }
            minutes++;
        }

        System.out.println(minutes);
    }
}

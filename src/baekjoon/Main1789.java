package baekjoon;

import java.io.*;

public class Main1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long left = 1, right = S;
        long ans = 0;

        while (left <= right) {								
            long mid = (left + right) / 2;
            long sum = mid * (mid + 1) / 2;

            if (sum <= S) {
                ans = mid;          // 더 큰 N이 가능할 수 있으므로 저장하고 계속
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
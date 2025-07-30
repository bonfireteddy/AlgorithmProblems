package baekjoon;

import java.util.*;
import java.io.*;

public class Main2417 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long left = 0, right = N;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            // mid가 0일 경우 0으로 나누는 걸 방지!
            if (mid == 0 || mid <= N / mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (ans * ans < N) ans++;
        System.out.println(ans);
	}

}

package baekjoon;

import java.util.*;
import java.io.*;

public class Main2503 {
    static class Hint {
        String num;
        int strike;
        int ball;

        Hint(String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Q = Integer.parseInt(br.readLine());
        List<Hint> hints = new ArrayList<>();

        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            hints.add(new Hint(num, s, b));
        }

        int count = 0;

        // 123부터 987까지의 모든 숫자 중 중복 없는 세자리 수 확인
        for (int i = 123; i <= 987; i++) {
            String candidate = String.valueOf(i);

            // 0 포함되거나 중복 숫자면 패스
            if (hasZeroOrDuplicate(candidate)) continue;

            boolean isValid = true;

            // 각 힌트 조건을 모두 만족하는지 확인
            for (Hint hint : hints) {
                int s = 0, b = 0;

                for (int j = 0; j < 3; j++) {
                    if (candidate.charAt(j) == hint.num.charAt(j)) {
                        s++;
                    } else if (hint.num.contains(String.valueOf(candidate.charAt(j)))) {
                        b++;
                    }
                }

                if (s != hint.strike || b != hint.ball) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) count++;
        }

        System.out.println(count);
    }

    static boolean hasZeroOrDuplicate(String s) {
        return s.contains("0") || s.charAt(0) == s.charAt(1)
                || s.charAt(0) == s.charAt(2)
                || s.charAt(1) == s.charAt(2);
    }
}


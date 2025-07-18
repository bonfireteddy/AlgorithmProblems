package baekjoon;

import java.util.*;

public class Main1713 {
    static class Student {
        int num;    // 학생 번호
        int rec;    // 추천 수
        int time;   // 게시된 시간

        Student(int num, int rec, int time) {
            this.num = num;
            this.rec = rec;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();         // 사진틀 수
        int M = sc.nextInt();         // 총 추천 수

        List<Student> frame = new ArrayList<>();

        for (int t = 0; t < M; t++) {
            int num = sc.nextInt();

            boolean isExist = false;
            for (Student s : frame) {
                if (s.num == num) {
                    s.rec++;         // 이미 있으면 추천수 증가
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                if (frame.size() < N) {
                    frame.add(new Student(num, 1, t));  // 비어 있으면 바로 추가
                } else {
                    // 추천 수 적고, 오래된 학생 제거
                    frame.sort((a, b) -> {
                        if (a.rec == b.rec) return a.time - b.time;
                        return a.rec - b.rec;
                    });
                    frame.remove(0);
                    frame.add(new Student(num, 1, t));
                }
            }
        }

        // 학생 번호 오름차순 출력
        frame.sort(Comparator.comparingInt(a -> a.num));

        for (Student s : frame) {
            System.out.print(s.num + " ");
        }
    }
}

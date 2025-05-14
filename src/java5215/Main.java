package java5215;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] nums = {1, 2, 3, 4, 5};
    static boolean[] visited = new boolean[5];
    static List<Integer> combination = new ArrayList<>();

    public static void main(String[] args) {
        int r = 3; // 예: 3개를 뽑는 조합
        dfs(0, 0, r);
    }

    static void dfs(int depth, int start, int r) {
        if (depth == r) {
            System.out.println(combination);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            combination.add(nums[i]);
            dfs(depth + 1, i + 1, r); // 조합: i+1부터 시작
            combination.remove(combination.size() - 1);
        }
    }
}

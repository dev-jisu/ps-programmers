package Network;

import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println(solution.solution(3, computers));
    }
}

class Solution {

    int[][] network;
    Set<Integer> checked = new HashSet<>();

    public int solution(int n, int[][] computers) {
        int answer = 0;
        network = computers;
        for (int i = 0; i < n; i++) {

            if (!checked.contains(i)) {
                answer++;
                dfs(i);
            }
        }
        return answer;
    }

    public void dfs(int computerNo) {
        checked.add(computerNo);
        for (int i = 0; i < network[computerNo].length; i++) {
            if (i != computerNo && network[computerNo][i] == 1 && !checked.contains(i)) {
                dfs(i);
            }
        }
    }
}
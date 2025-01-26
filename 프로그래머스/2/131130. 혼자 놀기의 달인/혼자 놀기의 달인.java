import java.util.*;

class Solution {

    List<Integer> group;
    
    public int solution(int[] cards) {

        group = new ArrayList<>();
        boolean[] visited = new boolean[cards.length + 1];

        for (int card : cards) {
            if (visited[card]) continue;

            dfs(card, 0, cards, visited);
        }

        if (group.size() == 1) return 0;

        group.sort(Comparator.reverseOrder());
        return group.get(0) * group.get(1);
    }

    void dfs(int now, int cnt, int[] cards, boolean[] visited) {
        if (visited[now]) {
            group.add(cnt);
            return;
        }

        visited[now] = true;
        dfs(cards[now - 1], cnt + 1, cards, visited);
    }
}

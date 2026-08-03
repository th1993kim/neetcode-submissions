class Solution {

    private boolean result;
    public boolean validTree(int n, int[][] edges) {
        result = true;
        boolean[] visited = new boolean[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int pre = edges[i][0];
            int back = edges[i][1];

            graph[pre].add(back);
            graph[back].add(pre);
        }


        dfs(visited, 0, -1, graph);

        for (int i = 0; i < n; i++) {
            if(!visited[i]) return false;
        }
        return result;
    }

    private void dfs(boolean[] visited, int root, int parent, List<Integer>[] graph) {
        System.out.println("root :" + root + ", visited : " + visited[root]);
        if (!result) return;
        if (visited[root]) {
            result = false;
            return;
        }

        visited[root] = true;
        for (Integer sub : graph[root]) {
            if (sub == parent) continue;
            dfs(visited, sub, root, graph);
        }
    }
}

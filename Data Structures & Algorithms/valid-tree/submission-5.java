 class Solution {

        public boolean validTree(int n, int[][] edges) {
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

            boolean result = hasCycle(visited, graph);

            for (int i = 0; i < n; i++) {
                if(!visited[i]) return false;
            }
            return !result;
        }

        private boolean hasCycle(boolean[] visited, List<Integer>[] graph) {
            Queue<int[]> queue = new ArrayDeque<>();

            queue.offer(new int[]{0, -1});
            visited[0] = true;
            while(!queue.isEmpty()) {
                int[] number = queue.poll();
                int current = number[0];
                
                for (Integer child : graph[current]) {
                    int parent = number[1];
                    
                    if (child == parent) continue;

                    if (visited[child]) {
                        return true;
                    }
                   
                    visited[child] = true;
                    queue.offer(new int[]{child, current});
                    
                }
            }

            return false;
        }
    }
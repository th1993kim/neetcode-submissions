 class Solution {

        public boolean validTree(int n, int[][] edges) {
            
            if (edges.length < n - 1) return false;

            int[] group = new int[n];

            for (int i = 0; i < n; i++) {
                group[i] = i;
            }

            for (int i = 0; i < edges.length; i++) {
                int pre = edges[i][0];
                int back = edges[i][1];
                if (!union(pre, back, group)) return false;
            }

            return true;
        }


        private boolean union(int a, int b, int[] group) {
            if (find(a, group) == find(b, group)) return false;
            int rootB = find(b, group);
            
            group[rootB] = find(a, group);
            return true;
        }

        private int find(int a, int[] group) {
            if (group[a] == a) return a;
            
            return group[a] = find(group[a], group);
        }
    }
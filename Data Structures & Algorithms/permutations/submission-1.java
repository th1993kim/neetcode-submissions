class Solution {

    private List<List<Integer>> answer;
        private boolean[] visited;

        public List<List<Integer>> permute(int[] nums) {
            answer = new ArrayList<>();
            visited = new boolean[nums.length];
            dfs(0, new ArrayList<>(), nums);
            return answer;
        }

        private void dfs(int length, List<Integer> subList, int[] nums) {
            if (length == nums.length) {
                answer.add(new ArrayList<>(subList));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    subList.add(nums[i]);
                    visited[i] = true;
                    dfs(length + 1, subList, nums);
                    subList.remove(subList.size() - 1);
                    visited[i] = false;
                }
            }
        }
}

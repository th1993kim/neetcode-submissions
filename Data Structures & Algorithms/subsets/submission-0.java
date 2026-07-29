class Solution {

    private List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        dfs(0, nums.length, new ArrayList<>(), nums);

        return answer;
    }

    private void dfs(int index, int max, List<Integer> subSet, int[] nums) {
        if (index == max) {
            answer.add(new ArrayList<>(subSet));
            return;
        }

        dfs(index + 1, max, subSet, nums);  
        subSet.add(nums[index]);
        dfs(index + 1, max, subSet, nums);
        subSet.remove(subSet.size() - 1);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> answer = new ArrayList<>();
            
            dfs(root, 0, answer);
            
            return answer;
        }
        
        private void dfs(TreeNode node, int depth, List<List<Integer>> answer) {
            if (node == null) {
                return;
            }
            if (depth == answer.size()) {
                answer.add(new ArrayList<>());
            }
            answer.get(depth).add(node.val);
            
            dfs(node.left, depth + 1, answer);
            dfs(node.right, depth + 1, answer);
        }
}

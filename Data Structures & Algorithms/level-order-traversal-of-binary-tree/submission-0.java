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
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);

        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            List<Integer> depthList = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    depthList.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if (!depthList.isEmpty()) {
                answer.add(depthList);
            }

        }
        
        return answer;
    }
}

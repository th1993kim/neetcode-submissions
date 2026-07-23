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
    public List<Integer> rightSideView(TreeNode root) {
        // BFS를 돌리는데 Queue의 맨마지막 노드만 결과에 넣는다. 

        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return answer;
        queue.add(root);
    
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (i == queueSize - 1) {
                    answer.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return answer;
    }
}

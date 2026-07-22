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

    int answer = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        calculateDepth(root);    


        return answer;
    }

    private int calculateDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = calculateDepth(root.left);
        int rightDepth = calculateDepth(root.right);

        answer = Math.max(answer, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}

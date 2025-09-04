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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxi = new int[1];
        findHeight(root , maxi);
        return maxi[0];
    }
    public static int findHeight(TreeNode root , int[] maxi){
        if(root == null) return 0;
        int leftH = findHeight(root.left,maxi);
        int rightH = findHeight(root.right,maxi);
        maxi[0] = Math.max(maxi[0] , leftH+rightH);
        return 1+Math.max(leftH , rightH);
    }
}
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
    private static int postIndex;
    private static Map<Integer , Integer> mp;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        mp = new HashMap<>();
        postIndex = postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i] , i);
        }
        return buildTreeHelper(postorder , 0 , inorder.length-1);
    }
    private static TreeNode buildTreeHelper(int[]postorder , int inStart , int inEnd){
        if(inStart>inEnd) return null;
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = mp.get(rootVal);

        root.right = buildTreeHelper(postorder , rootIdx+1 , inEnd);
        root.left = buildTreeHelper(postorder , inStart , rootIdx-1);

        return root;
    }
}
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //preorder(root, list);
        if(root == null)return list;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.empty()){
            TreeNode node = st.pop();
            list.add(node.val);
            if(node.right!=null)st.push(node.right);
            if(node.left!= null)st.push(node.left);
        }

        return list;
    }





    private void preorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);             // Root
        preorder(node.left, list);      // Left
        preorder(node.right, list);     // Right
    }
}

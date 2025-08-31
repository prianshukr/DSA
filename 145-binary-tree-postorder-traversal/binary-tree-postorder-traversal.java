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
    public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root, lastVisited = null;

    while (current != null || !stack.isEmpty()) {
        // Step 1: Push left nodes
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        TreeNode peekNode = stack.peek();
        
        // Step 2: If right child exists and not visited → move right
        if (peekNode.right != null && lastVisited != peekNode.right) {
            current = peekNode.right;
        } else {
            // Step 3: Process node
            result.add(peekNode.val);
            lastVisited = stack.pop();
        }
    }
    
    return result;
}


    private static void postOrder(TreeNode root , ArrayList<Integer> list){
        if(root == null) return;
        postOrder(root.left , list);
        postOrder(root.right , list);
        list.add(root.val);
    }
}
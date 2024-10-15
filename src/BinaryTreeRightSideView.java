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
// DFS Solution
// TC: O(n)
// SC: O(h)
class BinaryTreeRightSideView {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        if(root == null) return;
        if(result.size() == level)
            result.add(root.val);
        helper(root.right, level+1);
        helper(root.left,level+1);
    }
}

//BFS Solution
// TC: O(n)
// SC : O(n)

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
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left!= null)
                    q.add(curr.left);
                if(curr.right!= null)
                    q.add(curr.right);
            }
            result.add(li.get(size-1));
        }
        return result;
    }
}
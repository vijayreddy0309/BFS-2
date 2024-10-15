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

// BFS Solution
// TC: O(n)
// SC: O(n)
class CousinsInaBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode parentX = null;
        TreeNode parentY = null;
        int depthX = 1;
        int depthY = 1;
        int depth = 0;
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                if(curr.left!= null) {
                    q.add(curr.left);
                    if (curr.left.val == x) {
                        parentX = curr;
                        depthX = depth + 1;
                    } else if (curr.left.val == y) {
                        parentY = curr;
                        depthY = depth + 1;
                    }
                }
                if(curr.right!= null) {
                    q.add(curr.right);
                    if (curr.right.val == x) {
                        parentX = curr;
                        depthX = depth + 1;
                    } else if (curr.right.val == y) {
                        parentY = curr;
                        depthY = depth + 1;
                    }
                }

                if (parentX != null && parentY != null) {
                    return depthX == depthY && parentX != parentY;
                }
            }
            depth++;
        }
        return false;
    }
}

// DFS Solution
// TC: O(n)
// SC: O(h)
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
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,0,null,x,y);
        return (x_depth == y_depth && x_parent!= y_parent);
    }

    private void helper(TreeNode root, int depth, TreeNode parent, int x, int y) {
        if(root == null) return;
        
        if(root.val == x) {
            x_depth = depth;
            x_parent = parent;
        }
        if(root.val == y) {
            y_depth = depth;
            y_parent = parent;
        }
        
        helper(root.left, depth+1, root, x, y);
        helper(root.right, depth+1, root, x, y);
    }
}
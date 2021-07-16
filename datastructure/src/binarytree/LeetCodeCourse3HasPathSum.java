package binarytree;

public class LeetCodeCourse3HasPathSum {

    /**
     * Recursion
     * Time:O(n), Space:O(height)
     * Version 1.0 2021-07-16 by XCJ
     * @param root root of the tree
     * @param targetSum sum of the values in the path
     * @return true, the path exists | false, the path doesn't exist
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }


    /**
     * Recursion_Modified
     * Time:O(n), Space:O(height)
     * Version 2.0 2021-07-16 by XCJ
     * @param root root of the tree
     * @param targetSum sum of the values in the path
     * @return true, the path exists | false, the path doesn't exist
     */
    public boolean hasPathSum_DFS(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root,targetSum);
    }

    private boolean dfs(TreeNode root, int num) {
        // leaf node
        if (root.left == null && root.right == null) {
            return (num - root.val) == 0;
        }
        // has left child || right child
        return (root.left != null && dfs(root.left,num - root.val)) ||
                (root.right != null && dfs(root.right, num - root.val));
    }

}

package binarytree;

public class LeetCodeCourse1MaxDepth {
    /**
     * Recursion
     * Time:O(n), Space:O(height)
     * Version 1.0 2021-07-16 by XCJ
     * @param root root of the binary tree
     * @return height of the binary tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

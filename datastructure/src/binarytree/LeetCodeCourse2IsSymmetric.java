package binarytree;

public class LeetCodeCourse2IsSymmetric {

    /**
     * Recursion
     * Time:O(n), Space:O(height)
     * Version 1.0 2021-07-16 by XCJ
     * @param root root of the binary tree
     * @return true, the tree is symmetric | false, the tree is not symmetric
     */
    public boolean isSymmetric_Recursion(TreeNode root) {
        return check(root, root);
    }
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}

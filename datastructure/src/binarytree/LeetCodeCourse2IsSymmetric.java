package binarytree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCodeCourse2IsSymmetric {

    /**
     * Recursion
     * Time:O(n), Space:O(height)
     * Version 1.0 2021-07-16 by XCJ
     * @param root root of the binary tree
     * @return true, the tree is symmetric | false, the tree is not symmetric
     */
    public boolean isSymmetric_Recursion(TreeNode root) {
        return check_Recursion(root, root);
    }
    public boolean check_Recursion(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check_Recursion(p.left, q.right) && check_Recursion(p.right, q.left);
    }

    /**
     * Iteration
     * Time:O(n), Space:O(n)
     * Version 1.0 2021-07-16 by XCJ
     * @param root root of the binary tree
     * @return true, the tree is symmetric | false, the tree is not symmetric
     */
    public boolean isSymmetric_Iteration(TreeNode root) {
        return check_Iteration(root, root);
    }
    public boolean check_Iteration(TreeNode u, TreeNode v) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(u);
        queue.offer(v);
        while (!queue.isEmpty()) {
            u = queue.poll();
            v = queue.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            queue.offer(u.left);
            queue.offer(v.right);

            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }
}

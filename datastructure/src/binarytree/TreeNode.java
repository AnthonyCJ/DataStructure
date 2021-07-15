package binarytree;
import java.util.ArrayList;
import java.util.List;

/**
 * Node Definition for Binary Tree
 * 2021-07-15 by XCJ
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree {
    /**
     * 二叉树前序遍历递归算法
     * @param root 二叉树根节点
     * @return 数组 res，按前序遍历顺序保存访问的元素
     */
    public List<Integer> preorderTraversal_Recursion(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    /**
     * 二叉树前序遍历 Morris算法
     * @param root 二叉树根节点
     * @return 数组 res，按前序遍历顺序保存访问的元素
     */
    public List<Integer> preorderTraversal_Morris(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();   // 按顺序存储访问的元素
        if (root == null) {
            return res;
        }

        TreeNode currNode = root, mostRight = null;  // p1用于遍历+访问节点，p2用于构造临时路径。

        while (currNode != null) {
            mostRight = currNode.left;
            if (mostRight != null) {   // 左子树非空，找到当前节点在中序遍历下的前驱节点
                while (mostRight.right != null && mostRight.right != currNode) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) { // 为空则访问、构造路径、进入左子树
                    res.add(currNode.val);    // 访问
                    mostRight.right = currNode;      // 构造路径
                    currNode = currNode.left;       // 进入左子树
                    continue;
                } else {
                    mostRight.right = null;    // 不为空说明已返回，则将指针恢复为null。
                }
            } else {    // 左子树为空
                res.add(currNode.val);    // 访问当前节点
            }
            currNode = currNode.right;  // 遍历当前节点的右子树
        }
        return res;
    }

}

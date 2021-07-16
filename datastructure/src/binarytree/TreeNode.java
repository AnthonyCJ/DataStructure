package binarytree;
import java.util.*;

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

    /**
     * 二叉树前序遍历递归算法
     * @param root 二叉树根节点
     * @return 数组 res，按中序遍历顺序保存访问的元素
     */
    public List<Integer> inorderTraversal_Recursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 二叉树前序遍历迭代算法
     * @param root 二叉树根节点
     * @return 数组 res，按中序遍历顺序保存访问的元素
     */
    public List<Integer> inorderTraversal_Iteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * 二叉树中序遍历 Morris算法
     * @param root 二叉树根节点
     * @return 数组 res，按中序遍历顺序保存访问的元素
     */
    public List<Integer> inorderTraversal_Morris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode currNode = root, predecessor = null;
        while (currNode != null) {
            if (currNode.left != null) {
                // 找到currNode的前驱节点
                predecessor = currNode.left;
                while (predecessor.right != null && predecessor.right != currNode) {
                    predecessor = predecessor.right;
                }
                // 如果不存在返回路径，则构造返回路径，并进入currNode的左子树
                if (predecessor.right == null) {
                    predecessor.right = currNode;
                    currNode = currNode.left;
                }
                // 存在返回路径，说明左子树已访问完，此时先清除路径，再访问currNode，再进入右子树
                else {
                    predecessor.right = null;
                    res.add(currNode.val);
                    currNode = currNode.right;
                }
            }
            // 如果没有左子树，则先访问当前节点，并进入右子树
            else {
                res.add(currNode.val);
                currNode = currNode.right;
            }
        }
        return res;
    }


    /**
     * 二叉树后序遍历 递归算法
     * @param root 二叉树根节点
     * @return 数组 res，按后序遍历顺序保存访问的元素
     */
    public List<Integer> postorderTraversal_Recursion(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    /**
     * 二叉树后序遍历 迭代算法
     * @param root 二叉树根节点
     * @return 数组 res，按后序遍历顺序保存访问的元素
     */
    public List<Integer> postorderTraversal_Iteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, prev = null;
        while (curr != null || !stack.isEmpty()) {
            // 从当前节点开始，将root及所有左子节点入栈
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            // 无右子树或右子树已访问
            if (curr.right == null || curr.right == prev) {
                res.add(curr.val);  // 访问当前节点
                prev = curr;        // 更新前驱节点
                curr = null;        // 置空，防止已访问的 curr 节点再次入栈
            }
            // 右子树未被访问过，则记录根节点并访问右子树
            else {
                stack.push(curr);
                curr = curr.right;
            }
        }
        return res;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);  // offer() returns false if the queue is full
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currNode = queue.poll();   // poll() returns null if the queue is empty
                level.add(currNode.val);
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }
        return ret;
    }
}

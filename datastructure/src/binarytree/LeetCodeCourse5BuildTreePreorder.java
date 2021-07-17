package binarytree;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeCourse5BuildTreePreorder {
    int preIndex;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

    public TreeNode builder(int inLeft, int inRight) {
        // 递归出口
        if (inLeft > inRight) return null;

        // 选择 preIndex 位置的元素作为当前子树根节点
        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);

        // 根据 root 所在位置分成左右两棵子树
        int index = indexMap.get(rootVal);

        preIndex++;    // 后序遍历数组根节点指针自增一
        root.left = builder(inLeft, index - 1);    // 构造左子树
        root.right = builder(index + 1, inRight);   // 构造右子树

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        // 从后续遍历数组最后一个元素开始构造
        this.preIndex = 0;

        // 构建以（元素，下标）为键值对的哈希表
        int index = 0;
        for (Integer val : inorder) {
            indexMap.put(val, index++);
        }

        return builder(0, inorder.length - 1);
    }
}

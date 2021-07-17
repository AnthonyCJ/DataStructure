package binarytree;
import java.util.Map;
import java.util.HashMap;

public class LeetCodeCourse5BuildTreePreorderPlus {
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode builder(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        // 递归出口
        if (preorderLeft > preorderRight) return null;

        // 前序遍历中的第一个节点为根节点
        int preorderRootIndex = preorderLeft;
        int inorderRootIndex = indexMap.get(preorder[preorderRootIndex]);

        TreeNode root = new TreeNode(preorder[preorderRootIndex]);
        // 得到左子树节点数
        int sizeLeftSubtree = inorderRootIndex - inorderLeft;
        // 递归地构造左子树
        root.left = builder(preorder, inorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree,
                inorderLeft, inorderRootIndex - 1);
        root.right = builder(preorder, inorder, preorderLeft + sizeLeftSubtree + 1, preorderRight,
                inorderRootIndex + 1, inorderRight);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 构建以（元素，下标）为键值对的哈希表
        int index = 0;
        for (Integer val : inorder) {
            indexMap.put(val, index++);
        }
        return builder(preorder, inorder, 0, index - 1, 0, index - 1);
    }
}

package binarytree;
import java.util.Map;
import java.util.HashMap;

public class LeetCodeCourse4BuildTreePostorder {
    int postIndex;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

    public TreeNode builder(int inLeft, int inRight) {
        // 递归出口
        if (inLeft > inRight) return null;

        // 选择 postIndex 位置的元素作为当前子树根节点
        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);

        // 根据 root 所在位置分成左右两棵子树
        int index = indexMap.get(rootVal);

        postIndex--;    // 后序遍历数组根节点指针自减一
        root.right = builder(index + 1, inRight);   // 构造右子树
        root.left = builder(inLeft, index - 1);    // 构造左子树

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
         this.postorder = postorder;
         this.inorder = inorder;
         // 从后续遍历数组最后一个元素开始构造
        this.postIndex = postorder.length - 1;

        // 构建以（元素，下标）为键值对的哈希表
        int index = 0;
        for (Integer val : inorder) {
            indexMap.put(val, index++);
        }

        return builder(0, inorder.length - 1);
    }
}

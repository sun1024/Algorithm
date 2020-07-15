import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (68.47%)
 * Likes:    242
 * Dislikes: 0
 * Total Accepted:    42.5K
 * Total Submissions: 61.7K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 趁热打铁，思路和105差不多的：
// 中序：左根右
// 后序：左右根
// 递归的用根节点划分左右子树
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;

        for(int i=0; i<len; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, len-1, 0, len-1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR) {
        // 递归退出条件
        if(inL>inR || postL>postR) return null;

        TreeNode root = new TreeNode(postorder[postR]);
        int index = map.get(root.val);

        root.left = buildTree(inorder, postorder, inL, index-1, postL, index-inL+postL-1);
        root.right = buildTree(inorder, postorder, index+1, inR, index-inL+postL, postR-1);
        return root;
    }
}
// @lc code=end


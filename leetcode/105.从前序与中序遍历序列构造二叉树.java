/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (65.57%)
 * Likes:    570
 * Dislikes: 0
 * Total Accepted:    94.7K
 * Total Submissions: 140.4K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
// 前序：根左右
// 中序：左根右
// 递归的用根节点区分左右
// 每次都要用前序里的根节点去找它在中序里的位置
// 所以可以提前用map将中序数组的key-value存起来
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;
        if(preLength != inLength) return null;

        for(int i=0; i<inLength; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preLength-1, 0, inLength-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
        if(preL>preR || inL>inR) return null;

        TreeNode root = new TreeNode();
        root.val = preorder[preL]; // 根节点的值是前序数组的第一个元素
        int index = map.get(preorder[preL]); // 根节点在中序数组中的位置
        // 这里左右边界画个图就很容易理解了
        root.left = buildTree(preorder, inorder, preL+1, index-inL+preL, inL, index-1);
        root.right = buildTree(preorder, inorder, index-inL+preL+1, preR, index+1, inR);
        return root;
    }
}
// @lc code=end


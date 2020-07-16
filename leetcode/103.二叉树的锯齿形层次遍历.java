import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (54.42%)
 * Likes:    220
 * Dislikes: 0
 * Total Accepted:    57.9K
 * Total Submissions: 106.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回锯齿形层次遍历如下：
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
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
// 一样是层次遍历的变形，最容易理解的就是在每一层上按奇偶判断
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0; // 层数判断奇偶
        while(!queue.isEmpty()) {
            // 要使用addFirst，必须直接初始化为LinkedList
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode temp = queue.poll();
                // 奇偶判断
                if(level%2 == 0) list.add(temp.val);
                else list.addFirst(temp.val); // 这里利用LinkedList的方法直接往前插
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            res.add(list);
            level++;
        }
        return res;
    }
}
// @lc code=end


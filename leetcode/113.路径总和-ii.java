/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (59.63%)
 * Likes:    279
 * Dislikes: 0
 * Total Accepted:    61.2K
 * Total Submissions: 101K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \    / \
 * ⁠       7    2  5   1
 * 
 * 
 * 返回:
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
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
// 有点迷糊，看题解意思做出来了
class Solution {
    ArrayList<Integer> temp = new ArrayList<>(); // 存每条路
    List<List<Integer>> res = new ArrayList<>(); // 确定一条路就存进res
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return res;
        dfs(root, res, sum);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int sum) {
        // 递归结束条件
        if(root == null) return; 
        // 加入路径
        temp.add(root.val);
        // 确定一条路
        if(root.left == null && root.right == null && sum == root.val) {
            // 这里必须add一个新的数组，直接add(temp)的话，temp会继续变化的
            res.add(new ArrayList<>(temp)); 
        }
        // 后序遍历 这里不太好理解
        // 左右根的方式遍历 方便进行回溯
        if(root.left != null) dfs(root.left, res, sum-root.val);
        if(root.right != null ) dfs(root.right, res, sum-root.val);
        temp.remove(temp.size()-1); // 到达叶子但是不等于sum，则删掉叶子节点进行回溯
    }
}
// @lc code=end


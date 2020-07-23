// https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&&tqId=11177&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
import java.util.ArrayList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
// leetcode 113 再敲一遍 加深记忆
public class Solution {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        //if(root == null) return res; // 多余
        dfs(root, target);
        return res;
    }
    private void dfs(TreeNode root, int target) {
        if(root == null) return;
        temp.add(root.val);
        if(root.left == null && root.right == null && target == root.val) {
            res.add(new ArrayList<>(temp)); // 浅拷贝
        }
        // 后序遍历 回溯
        if(root.left != null) dfs(root.left, target-root.val);
        if(root.right != null) dfs(root.right, target-root.val);
        temp.remove(temp.size()-1);
    }
}
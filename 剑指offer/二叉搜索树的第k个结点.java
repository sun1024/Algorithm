// https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&&tqId=11215&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
import java.util.*;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
// 第一反映直接中序
// public class Solution {
//     ArrayList<TreeNode> temp = new ArrayList<>();
//     TreeNode KthNode(TreeNode pRoot, int k)
//     {
//         if(pRoot == null) return null;
//         // 中序遍历就是有序的
//         inOrder(pRoot);
//         if(temp.size() >= k && k >0) return temp.get(k-1);
//         else return null;
//     }
//     private void inOrder(TreeNode root) {
//         if(root == null) return;
//         // 左中右
//         if(root.left != null) inOrder(root.left);
//         temp.add(root);
//         if(root.right != null) inOrder(root.right);
//     }
// }
// 中序遍历，找到第k个就返回
public class Solution {
    int count = 0;
    TreeNode res;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null) return null;
        // 中序遍历就是有序的
        inOrder(pRoot, k);
        return res;
    }
    private void inOrder(TreeNode root, int k) {
        if(root == null) return;
        // 左中右
        if(root.left != null) inOrder(root.left, k);
        count++;
        if(count == k) {
            res = root;
            return;
        }
        if(root.right != null) inOrder(root.right, k);
    }
}
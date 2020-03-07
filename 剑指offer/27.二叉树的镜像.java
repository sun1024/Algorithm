// https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
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
// 递归 swap(每个左子树，每个右子树)
// public class Solution {
//     public void Mirror(TreeNode root) {
//         reverse(root);
//     }
//     private TreeNode reverse(TreeNode root) {
//         if(root == null) return null;
//         TreeNode temp = root.left;
//         root.left = reverse(root.right);
//         root.right = reverse(temp);
//         return root;
//     }
// }
// 迭代
import java.util.*;
public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                // 同样的交换每个左右子树
                TreeNode node = queue.remove();
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
    }
}
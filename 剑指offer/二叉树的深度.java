// https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=11191&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
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
// 递归
// public class Solution {
//     public int TreeDepth(TreeNode root) {
//         if(root==null) return 0;
//         return Math.max(TreeDepth(root.left), TreeDepth(root.right))+1;
//     }
// }
// 层次遍历
import java.util.*;
public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.remove();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return depth;
    }
}
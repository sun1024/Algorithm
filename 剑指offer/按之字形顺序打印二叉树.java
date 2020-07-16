// https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&&tqId=11212&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// leetcode 103 再敲一遍 加深印象
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
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int level = 0; // 层数
        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0; i<size; i++) {
                TreeNode temp = queue.poll();
                // 根据层数奇偶判断头插还是尾插
                if(level%2 == 0) list.add(temp.val); 
                else list.addFirst(temp.val);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            // 这里必须返回ArrayList，强行转下吧，懒得单独写array的头插了
            ArrayList<Integer> array = new ArrayList<>();
            reverse(list, array);
            res.add(array);
            level++;
        }
        return res;
    }
    
    private void reverse(LinkedList list, ArrayList array) {
        for(int i=0; i<list.size(); i++) {
            array.add(list.get(i));
        }
    }
}
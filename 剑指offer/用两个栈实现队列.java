// https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    int top = 0; // 记录栈顶
    
    public void push(int node) {
        stack1.push(node);
        top = node;
    }
    
    public int pop() {
        while(stack1.size()>1) {
            int temp = stack1.pop();
            stack2.push(temp);
            top = temp; //保存临时栈顶
        }
        int res = stack1.pop(); //出栈
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;
    }
}

// https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 双栈实现
import java.util.Stack;
public class Solution {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    
    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()) {
            stack2.push(node);
        } else if(node < stack2.peek()) {
            stack2.push(node);
        }
    }
    
    public void pop() {
        int temp = stack1.pop();
        if(temp == stack2.peek()) {
            stack2.pop();
        }
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int min() {
        return stack2.peek();
    }
}
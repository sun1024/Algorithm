import sun.misc.Queue;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 *
 * https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (62.12%)
 * Likes:    122
 * Dislikes: 0
 * Total Accepted:    30.9K
 * Total Submissions: 49.4K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * 使用队列实现栈的下列操作：
 * 
 * 
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 
 * 
 * 注意:
 * 
 * 
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty
 * 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * 
 * 
 */

// @lc code=start
class MyStack {

    /** Initialize your data structure here. */
    private Queue<Integer> q1; // 输入队列
    private Queue<Integer> q2; // 输出队列
    private int top; // 保存栈顶元素

    public MyStack() { // 链表实现队列
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top = x; 
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int res = top; //输出原来的栈顶
        while(q1.size()>1) {
            top = q1.remove(); //除开top元素外 全部存入q2 并记录栈顶
            q2.add(top);
        }
        q1.remove();
        // q1 q2交换
        Queue<Integer> temp = q1; 
        q1 = q2;
        q2 = temp;
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end


// https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
// 第一时间想到set，因为有且只有两个，所以最后肯定剩俩
// 题解表示可以用map，其实还比set麻烦
import java.util.*;
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Set<Integer> set = new HashSet<>();
        for(int i:array) {
            if(set.contains(i)) set.remove(i);
            else set.add(i);
        }
        Iterator<Integer> iterator = set.iterator();
        num1[0] = iterator.next();
        num2[0] = iterator.next();
    }
}
// 标准答案是异或，不看题解我是根本想不到的。。。

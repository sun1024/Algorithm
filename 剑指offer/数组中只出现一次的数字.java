// https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
// 第一时间想到set，因为有且只有两个，所以最后肯定剩俩
// 题解表示可以用map，其实还比set麻烦
// import java.util.*;
// public class Solution {
//     public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
//         Set<Integer> set = new HashSet<>();
//         for(int i:array) {
//             if(set.contains(i)) set.remove(i);
//             else set.add(i);
//         }
//         Iterator<Integer> iterator = set.iterator();
//         num1[0] = iterator.next();
//         num2[0] = iterator.next();
//     }
// }
// 标准答案是异或，时间O(n)，空间O(0)，不看题解我是根本想不到的。。。
// xor 性质：a^a=0 a^0=a a^b^c=a^c^b 1^1=0 0^0=0 1^0=1
// 如果只有一个数字出现一次，直接依次异或就能等到结果，但是有两个的话就会得到num1^num2的结果
// 因此要想办法分成两组，同时能把这两个数分开，再分开异或就能分别得到这两个数了
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int xor = 0; // 保存num1^num2 为什么初始化为0？因为 a^0=a
        for(int i:array) {
            xor ^= i;
        }
        int first = 1; // 用于寻找xor中第一个1
        while((first&xor) == 0) {
            //相与为0 则first左移一位 直到为1时 first的二进制表示就变成了1000...(1的位置就是xor第一个1)
            first = first << 1;
        }
        // 通过将first与数组中每一个数相与，可以将其分为两组，同时把num1、num2分开
        // 为什么能分开？
        // 因为异或的运算:不同则为1 num1和num2在first里1的那一位上不会相同 
        // 所以在xor中随便找一个二进制为1的地方用来区分 就能把num1、num2分开的
        for(int i:array) {
            if((i&first) == 0) {
                num1[0] ^= i;
            } else {
                num2[0] ^= i;
            }
        }
    }
}

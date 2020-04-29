// https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 简单的双指针
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int p1 = 0;
        int p2 = array.length-1;
        ArrayList<Integer> res = new ArrayList<>();
        while(p1<=p2) {
            if(array[p1]+array[p2] == sum) {
                res.add(array[p1]);
                res.add(array[p2]);
                return res;
            } else if(array[p1]+array[p2] > sum) {
                p2--;
            } else if(array[p1]+array[p2] < sum) {
                p1++;
            }
        }
        return res;
    }
}
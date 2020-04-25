// https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// O(n*n)
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        for(int i=0; i<array.length; i++) {
            int temp = 0;
            for(int j=i; j<array.length; j++) {
                temp += array[j];
                if(temp>max) max = temp;
            }
        }
        return max;
    }
}
// dp O(n)
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int curr_max=  array[0];
        for(int i=1; i<array.length; i++) {
            if(array[i] > curr_max+array[i]) curr_max = array[i];
            else curr_max += array[i];
            if(curr_max > max) max = curr_max;
        }
        return max;
    }
}

package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * L001_twoSum
����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
ʾ��:
���� nums = [2, 7, 11, 15], target = 9
��Ϊ nums[0] + nums[1] = 2 + 7 = 9
���Է��� [0, 1]
 * @author b1ng0
 *
 */
public class L001_twoSum {
		//����
		public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    //�����ϣ��
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    //һ���ϣ��
    public int[] twoSum3(int[] nums, int target) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i = 0; i < nums.length; i++) {
    		int complement = target - nums[i];
    		if(map.containsKey(complement) && map.get(complement) != i) {
    			return new int[] { i, map.get(complement)};
    		}
    	}
    	throw new IllegalArgumentException("No two sum solution");
    }
    
}

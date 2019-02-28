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
	public int[] twoSum(int[] nums, int target) {

		if (nums == null || nums.length <= 1) {
			return new int[2];
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		// key = target - nums[i], just one solution
		for (int i = 0; i < nums.length; i++) {
			map.put(target - nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			Integer v = map.get(nums[i]);

			// can't use itself
			if (v != null && v != i) {
				return new int[] { i + 1, v + 1 };
			}
		}

		return null;
	}
}

package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * L001_twoSum
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
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

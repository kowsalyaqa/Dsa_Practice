package Week2.Day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
Given a sorted array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

Input: nums = [2,3,5,7], target = 9
Output: [0,3]
Output: Because nums[0] + nums[3] == 9, we return [0, 3].*/

public class TwoSum {
	
	@Test
	public void test1() {
		int[] nums = { 2,3,5,7 };
		int[] actual= findIndicesOfTarget(nums,9);
		Assertions.assertArrayEquals(new int[] {0,3}, actual);
	}
	
	public int[] findIndicesOfTarget(int[] nums, int target) {
		int left=0,right=nums.length-1,sum=0;
		while(left<right) {
			sum=nums[left]+nums[right];
			if(sum==target) {
				return new int[] {left,right};
			}
			if(sum<target) {
				left++;
			}else if(sum>target) {
				right--;
			}
		}
		return new int[] {-1,-1};
	}
	
	//Time Complexity: O(N)
}

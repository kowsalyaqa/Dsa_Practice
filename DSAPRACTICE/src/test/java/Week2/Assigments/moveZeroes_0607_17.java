//https://leetcode.com/problems/move-zeroes/

/*Problem solving template

1. Did I understand the problem? yes or no ->Yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)?
        	integer array
        What is the expected output?
        	integer array with relative order not changed
        Do I’ve constraints to solve the problem? 
        	Solve in-place without making a copy of the array.
 
        Do Ive all the information to go to the next steps
        	Yes
        How big is your test data set will be?
			1 <= nums.length <= 104
			-2^31 <= nums[i] <= 2^31 - 1
				
2. Test data set
        Minimum  3 data set including positive, negative and edge

			Input: nums = [0,1,0,3,12]
			Output: [1,3,12,0,0]

			Input: nums = [0]
			Output: [0]
		
			Input: nums = [1,0,1]
			Output: [1,1,0]
	 
	 		Input: nums = [0,1]
			Output: [1,0]
			
			Input: nums = [0,1,-1,-2]
			Output: [1,-1,-2,0]
        
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it? 
        Yes- great is there an alternate ?
        	Two Pointer
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know

Simple technique brute force

/*
 * Declare left=0, right=0;
 * Iterate loop using right till array length-1
 * Compare left ele swap when non-zero ele identified via right pointer
 * Once swap it increment left by 1
 * suppose right ele is zero, move till get non-zero element
 */

/*completion_criteria
Applied the problem solving template - yes
Solved the question using brute force and specific algoirthm - yes
Pushed the code to github - yes
Solved the question in leetcode and observed all TCs passed - yes
*/

package Week2.Assigments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class moveZeroes_0607_17 {

	@Test
	public void test1() {
		int[] nums = { 1, 0, 1 };
		Assertions.assertArrayEquals(new int[] { 1, 1, 0 }, moveZeroes(nums));
		Assertions.assertArrayEquals(new int[] { 1, 1, 0 }, moveZeroes1(nums));
	}

	@Test
	public void test2() {
		int[] nums = { 0, 1, 0, 3, 12 };
		Assertions.assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, moveZeroes(nums));
		Assertions.assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, moveZeroes1(nums));
	}

	@Test
	public void test3() {
		int[] nums = { 0, 1, -1, -2 };
		Assertions.assertArrayEquals(new int[] { 1, -1, -2, 0 }, moveZeroes(nums));
		Assertions.assertArrayEquals(new int[] { 1, -1, -2, 0  }, moveZeroes1(nums));
	}
	
	@Test
	public void test4() {
		int[] nums = { 1,0,1 };
		Assertions.assertArrayEquals(new int[] { 1,1,0 }, moveZeroes(nums));
		Assertions.assertArrayEquals(new int[] { 1, 1, 0 }, moveZeroes1(nums));
	}
	
	@Test
	public void test5() {
		int[] nums = { 1,0,1 };
		Assertions.assertArrayEquals(new int[] { 1,1,0 }, moveZeroes2(nums));
	}

	// Brute force approach
	public int[] moveZeroes(int[] nums) {
		if(nums.length==0) {
			return nums;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == 0 && nums[j] != 0) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					break;
				}
			}
		}
		return nums;
	}
	// TC: O(N^2) SC:O(1)

	// Two pointer approach (Optimized Solution)
	public int[] moveZeroes1(int[] nums) {
		int left = 0, right = 0;//O(1)
		while (right < nums.length) {//O(N)
			if (nums[right] != 0) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
			}
			right++;
		}
		return nums;
	}
	// TC: O(N) SC:O(1)
	
	// Array approach 
	public int[] moveZeroes2(int[] nums) {
		int index=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0) {
				nums[index++]=nums[i];
			}
		}
		while(index<nums.length) {
			nums[index]=0;
		}
		return nums;
	}
	// TC: O(N) SC:O(1)
}

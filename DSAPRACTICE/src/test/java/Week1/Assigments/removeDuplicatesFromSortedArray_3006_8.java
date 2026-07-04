//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
/*1. Did I understand the problem? yes or no

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)?
        		Given an integer array nums sorted in non-decreasing order
        What is the expected output?
        		return the number of unique elements k
        Do I’ve constraints to solve the problem?
        		 remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
        Do Ive all the information to go to the next steps
        How big is your test data set will be?
	        	1 <= nums.length <= 3 * 104
			-100 <= nums[i] <= 100
			nums is sorted in non-decreasing order

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Input: nums = [1,1,2]
		Output: 2, nums = [1,2,_]
		
		Input: nums = [0,0,1,1,1,2,2,3,3,4]
		Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
		
		Input: nums = [ -2, -1, 1, 1, 2]
		Output: 1, nums = [-2, -1, 1, 2]
		
		Input: nums = [-2, -2]
		Output: 1, nums = [-2]
		
		Input: nums = [-2]
		Output: 1, nums = [-2]
		

        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it? ->Yes
        Yes- great is there an alternate ?
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know

Simple technique brute force

Pseudo Code for Brute Force approach:
1.Loop through the valid portion of the array
	a)If we find a duplicate neighbor
		b)Move every element after it one position to the left
	c)Reduce the size of our "valid" array since we removed an item
2.Move to the next element if no duplicate
3.n is now the count of unique elements

6. If you know the alternate solution find out the O-notations (performance)
7. Then, explain either both are the best (depends on the time)
        Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
        Approach 2: Write down the options and benefits and code the best
8. Start always with the Pseudo code (explain the pseudo code to the interviewer with some test data)
    -write the code
9. Test against different test data
10. If it fails then debug to solve it
11. Optimize the code and remove unnecessary code*/

package Week1.Assigments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class removeDuplicatesFromSortedArray_3006_8 {
	@Test
	public void test1() {
		int[] arr = { 1, 1, 2 };
		Assertions.assertEquals(2, removeDuplicateSortedArray1(arr));
		Assertions.assertEquals(2, removeDuplicateSortedArray2(arr));
	}

	@Test
	public void test2() {
		int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		Assertions.assertEquals(5, removeDuplicateSortedArray1(arr));
		Assertions.assertEquals(5, removeDuplicateSortedArray2(arr));
	}

	@Test
	public void test3() {
		int[] arr = { -2, -1, 1, 1, 2 };
		Assertions.assertEquals(4, removeDuplicateSortedArray1(arr));
		Assertions.assertEquals(4, removeDuplicateSortedArray2(arr));
	}

	@Test
	public void test4() {
		int[] arr = { -2, -2 };
		Assertions.assertEquals(1, removeDuplicateSortedArray1(arr));
		Assertions.assertEquals(1, removeDuplicateSortedArray2(arr));
	}
	
	@Test
	public void test5() {
		int[] arr = {-2};
		Assertions.assertEquals(1, removeDuplicateSortedArray1(arr));
		Assertions.assertEquals(1, removeDuplicateSortedArray2(arr));
	}


	// Brute Force Approach
	private int removeDuplicateSortedArray1(int[] nums) {
		if (nums.length == 0)
			return 0;
		int n = nums.length;
		int i = 0;
		while (i < n - 1) {
			if (nums[i] == nums[i + 1]) {
				for (int j = i + 1; j < n - 1; j++) {
					nums[j] = nums[j + 1];
				}
				n--;
			} else {
				i++;
			}
		}

		return n;
	}
	
	//Time Complexity: O(N^2)

	// Two pointer approach
	private int removeDuplicateSortedArray2(int[] nums) {
		int left = 0, right = 1;
		while (right < nums.length) {
			if (nums[left] != nums[right]) {
				left++;
				nums[left] = nums[right];
			} else {
				right++;
			}
		}
		return left + 1;
	}
	//Time Complexity:O(N)

}

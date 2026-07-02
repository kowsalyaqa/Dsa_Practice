//https://leetcode.com/problems/remove-element/description/

/*Problem solving template

1. Did I understand the problem? yes or no

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)?
        	an integer array nums and an integer val, 
        What is the expected output?
        	return the number of elements in nums which are not equal to val==>Return  Size of elements
        	
        Do I’ve constraints to solve the problem?
        		remove all occurrences of val in nums in-place.
        		
        		Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
		
				Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
				Return k.
        	
        Do Ive all the information to go to the next steps
        	Yes
        How big is your test data set will be?
        0 <= nums.length <= 100
		0 <= nums[i] <= 50
		0 <= val <= 100

2. Test data set
        Minimum  3 data set including positive, negative and edge
        
        Positive:
        Example 1:
		Input: nums = [3,2,2,3], val = 3
		Output: 2, nums = [2,2,_,_]
		Explanation: Your function should return k = 2, with the first two elements of nums being 2.
		It does not matter what you leave beyond the returned k (hence they are underscores).
		
		Example 2:
		Input: nums = [0,1,2,2,3,0,4,2], val = 2
		Output: 5, nums = [0,1,4,0,3,_,_,_]
		Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
		Note that the five elements can be returned in any order.
		It does not matter what you leave beyond the returned k (hence they are underscores).
		
		Negative Case:
		Input: nums = [2,2,2,2], val = 2
		Output: 0, nums = [_,_,_,_]
		
		Input: nums = [2], val = 3
		Output: 0, nums = [_]
		
		
		Edge Case:
		Input: nums = [], val = 
		Output: 0, nums = []
		
		Input: nums = [3,3], val = 5
		Output: 2, nums = [3,3]
		
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ?
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know

Simple technique brute force

6. If you know the alternate solution find out the O-notations (performance)
7. Then, explain either both are the best (depends on the time)
        Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
        Approach 2: Write down the options and benefits and code the best
8. Start always with the Pseudo code (explain the pseudo code to the interviewer with some test data)
    -write the code
9. Test against different test data
10. If it fails then debug to solve it
11. Optimize the code and remove unnecessary code*/

/*completion_criteria
Applied the problem solving template 
Solved the question using brute force and specific algoirthm
Pushed the code to github
Solved the question in leetcode and observed all TCs passed*/

package Week1.Assigments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveElement_2806_5 {

	@Test
	public void test1() {
		int[] arr = { 3,2,2,3};
		int value = 2;
		int expectedIndexCount = 2;
		int actualIndexCount = removeElement(arr, value);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
	}
	
	@Test
	public void test2() {
		int[] arr = { 0,1,2,2,3,0,4,2};
		int value = 2;
		int expectedIndexCount = 5;
		int actualIndexCount = removeElement(arr, value);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
	}

	@Test
	public void test3() {
		int[] arr = { 2,2,2,2};
		int value = 2;
		int expectedIndexCount = 0;
		int actualIndexCount = removeElement(arr, value);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
	}
	
	@Test
	public void test4() {
		int[] arr = {};
		int value = 2;
		int expectedIndexCount = 0;
		int actualIndexCount = removeElement(arr, value);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
	}
	
	@Test
	public void test5() {
		int[] arr = {2};
		int value = 3;
		int expectedIndexCount = 1;
		int actualIndexCount = removeElement(arr, value);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
	}

	@Test
	public void test6() {
		int[] arr = {3,3};
		int value = 5;
		int expectedIndexCount = 2;
		int actualIndexCount = removeElement(arr, value);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
	}

	
	// Brute Force Approach
	private int removeElement(int[] nums, int val) {
		if (nums == null)
			throw new RuntimeException("Array Input should not be Empty or null ");
		if (nums.length == 0)
			return 0; 
		int duplicateElement=0;
		for (int i = nums.length-1; i >= 0; i--) {
			 if(nums[i] == val) {
				 duplicateElement++;
				continue;
			}
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] == val) {
					duplicateElement++;
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					break;
				}
			}
		}
		return nums.length-duplicateElement;
	}
}
